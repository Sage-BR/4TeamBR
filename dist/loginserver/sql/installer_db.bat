@echo off

echo Checking environment...
mysql --help >nul 2>nul
if errorlevel 1 goto nomysql
echo   - MySQL: OK

set USER=root
set PASS=
set DBNAME=l2jdb
set DBHOST=127.0.0.1
set COMMAND="CREATE DATABASE IF NOT EXISTS "

mysql -h %DBHOST% -u %USER% --password=%PASS% -e "%COMMAND:"=%%DBNAME:"=%;"

for /r install %%f in (*.sql) do ( 
                echo Installing table %%~nf ...
		mysql -h %DBHOST% -u %USER% --password=%PASS% -D %DBNAME% < %%f
	)
:end

pause
