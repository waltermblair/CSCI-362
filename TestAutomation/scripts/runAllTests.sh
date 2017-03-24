#Change to directory of script.
cd "$(dirname "$0")"

#Create report
echo "<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Team TBD Tests</title>
		<link rel=\"stylesheet\" type=\"text/css\" href=\"../reports/style.css\" />
	</head>
	<body>
		<div id=\"table\">
			<div class=\"row\">
				<div class=\"head\">Test #</div>
				<div class=\"head\">Method</div>
				<div class=\"head\">Input</div>
				<div class=\"head\">Expected</div>
				<div class=\"head\">Outcome</div>
				<div class=\"head\">Result</div>
			</div>" > ../reports/testReport.html

#Run tests
for file in ../testCases/*; do

	#Get variables from text files
	test=$(sed -n '1p' "$file" | cut -f2 -d$'\t')
	desc=$(sed -n '2p' "$file" | cut -f2 -d$'\t')
	component=$(sed -n '3p' "$file" | cut -f2 -d$'\t')
	method=$(sed -n '4p' "$file" | cut -f2 -d$'\t')
	input=$(sed -n '5p' "$file" | cut -f2 -d$'\t')
	expected=$(sed -n '6p' "$file" | cut -f2 -d$'\t')
	driver=$(sed -n '7p' "$file" | cut -f2 -d$'\t')

	#Run the correct driver
	javac -cp "../project/src" ../testCasesExecutables/$driver.java

	#Change to parent directory
	cd ../testCasesExecutables

	#Get result from driver
	result=$(java -cp "./:../project/src" $driver $input)
	
	# need to round the result to 2 deci http://stackoverflow.com/questions/26465496/rounding-up-float-point-numbers-bash
	# http://unix.stackexchange.com/questions/167058/how-to-round-floating-point-numbers-in-shell
	result=$(echo $result | xargs printf "%.*f\n" 2)

	#Dump test case info into terminal
	echo "---------------------"
	echo "Test: $test "
	echo "---------------------"
	echo "Description: $desc"
	echo "Component: $component"
	echo "Method: $method"
	echo "Input: $input"
	echo "Expected: $expected"
	echo "Driver: $driver"
	echo "Result: $result"
	echo ""
	
	#Print results to report
	echo "			<div class=\"row\">
				<div class=\"cell\"><a href=\"../testCases/$file\">Test #$test</a></div>
				<div class=\"cell\">$method</div>
				<div class=\"cell\">$input</div>
				<div class=\"cell\">$expected</div>
				<div class=\"cell\">$result</div>" >> ../reports/testReport.html

	#Compare the output to expected and determine pass or fail
	if [ "$expected" == "$result" ]; then
		echo "				<div class=\"cell pass\">Pass</div>" >> ../reports/testReport.html
	else
		echo "				<div class=\"cell fail\">Fail</div>" >> ../reports/testReport.html
	fi


	echo "			</div>" >> ../reports/testReport.html

done 

echo "		</div>
	</body>
</html>" >> ../reports/testReport.html

#Open report
xdg-open ../reports/testReport.html
