@echo off
title 4TeamBR Game Server Console
color 0B
:start

REM -------------------------------------
REM Default parameters for a basic server.
java -Dfile.encoding=UTF8 -server -Xmx2g -server -XX:+UseCodeCacheFlushing -XX:+OptimizeStringConcat -XX:+UseG1GC -XX:+TieredCompilation -XX:+UseStringDeduplication -XX:+UseCompressedOops -XX:SurvivorRatio=8 -XX:NewRatio=4 -cp ./lib/*;4TeamBR.jar com.l24team.gameserver.GameServer
REM
REM If you have a big server and lots of memory, you could experiment for example with
REM java -server -Xmx1536m -Xms1024m -Xmn512m -XX:SurvivorRatio=8 -Xnoclassgc -XX:+AggressiveOpts
REM -------------------------------------

if ERRORLEVEL 5 goto taskrestart
if ERRORLEVEL 4 goto taskdown
REM 3 - abort
if ERRORLEVEL 2 goto restart
if ERRORLEVEL 1 goto error
goto end

:taskrestart
echo.
echo Auto Task Restart ...
echo.
goto start

:taskdown
echo .
echo Server terminated (Auto task)
echo .

:restart
echo.
echo Admin Restart ...
echo.
goto start

:end
echo.
echo server terminated
echo.
exit