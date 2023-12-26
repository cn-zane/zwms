@echo off
echo [INFO] Package...

%~d0
cd %~dp0

cd ..
call mvnd clean package -Dmaven.test.skip=true
pause
