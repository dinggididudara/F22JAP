:: ---------------------------------------------------------------------
:: JAP COURSE - SCRIPT
:: SCRIPT W01 - CST8221 - Fall 2022
:: ---------------------------------------------------------------------
:: Begin of Script (LabsSwing - F22)
:: ---------------------------------------------------------------------


CLS

@echo off

ECHO " _________________________________ "
ECHO "|     __    _  ___    ___  _      |"
ECHO "|    |  |  / \ \  \  /  / / \     |"
ECHO "|    |  | /   \ \  \/  / /   \    |"
ECHO "|    |  |/  _  \ \    / /  _  \   |"
ECHO "|  __|  |  / \  \ \  / /  / \  \  |"
ECHO "|  \____/_/   \__\ \/ /__/   \__\ |"
ECHO "|                                 |"
ECHO "| .. ALGONQUIN COLLEGE - 2022F .. |"
ECHO "|_________________________________|"
ECHO "                                   "
ECHO "[LABS SCRIPT ---------------------]"

ECHO "1. Compiling ......................"
javac -Xlint -cp ".;src" src/CST8221/Main.java -d bin 2> labs-javac.err

:: ECHO "Running  ........................."
:: start java -cp ".;bin;/SOFT/copy/dev/java/javafx/lib/*" CST8221.Main

ECHO "2. Creating Jar ..................."
cd bin
jar cvfe CST8221.jar CST8221.Main . > labs-jar.out 2> labs-jar.err

ECHO "3. Creating Javadoc ..............."
cd ..
javadoc -cp ".;bin" -d doc -sourcepath src -subpackages CST8221 2> labs-javadoc.err

cd bin
ECHO "4. Running Jar ...................."
start java -jar CST8221.jar
cd ..

ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (LabsSwing - F22)
:: ---------------------------------------------------------------------
