@echo off
echo [INFO] Installing dependencies...

%~d0
cd %~dp0

cd ..
call mvnd clean install -Dmaven.test.skip=true
pause
