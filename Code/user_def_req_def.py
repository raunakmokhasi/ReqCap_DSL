"""
@author = raunakmokhasi
This program is where the user-team can generate stubs for their own keywords.
"""
def create_python_func_defs_file(username):
    """
    creates and returns the python function definitions file.
    this file contains function stubs generated for user-defined keywords
    """
    python_func_defs_file = open("user_func_defs.py", 'w+')
    python_func_defs_file.write("\"\"\"\n@author=" + username + "\n")
    python_func_defs_file.write("this file contains function stubs generated from your input to user_def_req_def.py\n\"\"\"\n")
    return python_func_defs_file

def add_logic(keyword_entered, python_func_defs_file):
    """
    creates the function stub for keyword entered
    """
    python_func_defs_file.write("def interpret_" + keyword_entered + "():\n")
    python_func_defs_file.write("    \"\"\"\n    Start line in your req def text file with <*" + keyword_entered + "> (without the <>)\n")
    python_func_defs_file.write("    This function must return a string that contains the java code or comment that you want added to StepDefs.java\n    \"\"\"")
    python_func_defs_file.write("\n    # write your code here")
    python_func_defs_file.write("\n    java_code_string = \"\"\n    return java_code_string\n\n")

# get user input for name and keyword
username = input("Enter your username: ")
python_func_defs_file = create_python_func_defs_file(username.replace(" ", "_").lower())

keyword_entered = ""

while(True):
    keyword_entered = input("Enter the keyword. If done, enter n: ")
    if (keyword_entered == "n"):
        break
    add_logic(keyword_entered.replace(" ", "_").lower(), python_func_defs_file)

python_func_defs_file.close()
