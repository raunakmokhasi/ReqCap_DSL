"""
@author = raunakmokhasi
This program is the compiler for the ReqDef DSL.
"""
function_name_list = []

def read_file():
    """
    asks user to enter the name of the text file to analyze.
    then opens the file and returns it
    """
    in_file = input("Enter the name of text file without extension: ")+".txt"
    return open(in_file, 'r')

def create_function_name(list_words):
    """
    takes a list of words and creates a function name in java syntax
    """
    function_name = list_words[1]
    iter_words = iter(list_words)
    next(iter_words)
    next(iter_words)
    for word in iter_words:
        function_name = function_name + "_" + word
    return function_name

def check_duplicate_function(function_name):
    if function_name in function_name_list:
        return True
    else:
        function_name_list.append(function_name)
        return False

def identify_keywords(line, javaStepDefs_file):
    """
    parses the string and identifies keywords
    """
    list_words = line.split()
    if (list_words[0] == "Objective:"):
        javaStepDefs_file.write("// " + line + "\n\n")
    if (list_words[0] in ("Knowing", "If", "&&", "Then", "Else If")):
        function_name = create_function_name(list_words)
        result = check_duplicate_function(function_name)            
        if result == False:
            javaStepDefs_file.write("public void " + function_name + "(){}\n\n")

def create_javaStepDefs_file(package):
    """
    creates and returns the java step definitions file.
    this file contains test stubs generated from reqDef text file.
    """
    javaStepDefs_file = open("StepDefs.java", 'w+')
    javaStepDefs_file.write("package " + package + ";\n\n")
    javaStepDefs_file.write("public class StepDefs{\n")
    return javaStepDefs_file

# read input file that you want to analyze
document = read_file()

# get file contents and close
text = document.read()
document.close()

package = input("Enter the name of the package in which your StepDefs.java file will go: ")
javaStepDefs_file = create_javaStepDefs_file(package)

# main parsing logic
for line in text.splitlines():
    identify_keywords(line.strip(), javaStepDefs_file)

javaStepDefs_file.write("}")
javaStepDefs_file.close()
