@echo off

set /p a=是否确定需要部署到maven中央仓库(y/N)：
if "%a%"=="y" Goto deploy

goto end

:deploy
call mvn clean install
goto end

:end
pause