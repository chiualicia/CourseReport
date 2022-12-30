# Course Report

A basic software application that allows the user to inquire about a given course.

<img width="547" alt="image" src="https://user-images.githubusercontent.com/79593503/210107869-03bfdacb-2a5c-4494-9d25-43660efaab05.png">

## Description

A command line interface that enables an administrator to query and retrieve various details of a course using commandline options. The user is prompted for the name of the input file containing the course details. The program retrieves the file details, eliminates duplicates of any personnel (instructors, staff and students), and loads the data into the appropriate data structures for further processing. The user is then given several prompt options through a command-line menu.

### Dependencies

* Java version 8 or higher.

### Installing

1. Press the Fork button (top right the page) to save copy of this project on your account.
2. Clone this project by typing in Git Bash the following command:
```
$ git clone https://github.com/HouariZegai/Calculator.git
```
3. Import it to Intellij IDEA or other Java IDE.
4. Run. Enter either provided input text file (CourseRecords.txt) or your own when prompted.

## Help

A sample input text file is included. The order of the lines is insignificant, however the format of each personnel is crucial:
* Instructor: *lastName, firstName; ID# (5 digits); salary; yearOfHire; title
* Staff: *lastName, firstName; ID# (5 digits); salary; yearofHire; paygrade
* Undergraduate: *lastName, firstName; ID# (5 digits); standing (FRESHMAN, SOPHOMORE, JUNIOR, SENIOR)
* Graduate: *lastName, firstName; ID# (5 digits); program (MASTERS, DOCTORAL)

## Authors

Trevor Anderson
https://www.linkedin.com/in/trevor-anderson-9370341b7/

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

