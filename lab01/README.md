# Aula01 - Notes
## Run WSSolver.java

+ Compile:</br>
``` $ javac lab01/WSSolver.java lab01/Word.java lab01/Validation.java lab01/Solver.java lab01/Direction.java ```

+ Run examples:</br>
``` $ java lab01/WSSolver lab01/sopa0X.txt ``` where X should be replaced by a number between 1 and 3

+ Output:</br>
-- sopa0X_result.txt , X being the number used on running

## Run WSGenerator.java
+ Compile:</br>
``` $ javac lab01/WSGenerator.java```

+ Run examples in terminal:</br>
``` $ java lab01/WSGenerator -i lab01/wl0Y.txt -s 12 ``` where Y should be replaced by a number between 1 and 3, and the argument following -s is going to be soup size.

+ Run examples in terminal and write their ouput in file:</br>
``` $ java lab01/WSGenerator -i lab01/wl0Y.txt -s 12 -o "lab01/wl01_result.txt" ``` where file to write should come in between ```""```

+ Output:</br>
-- wl0Y_result.txt , Y being the number used on running
