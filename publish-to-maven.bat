@echo off

set /p a=�Ƿ�ȷ����Ҫ����maven����ֿ�(y/N)��
if "%a%"=="y" Goto deploy

goto end

:deploy
call mvn clean deploy -Dgpg.skip=false
goto end

:end
pause