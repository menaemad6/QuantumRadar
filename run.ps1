Set-Location $PSScriptRoot

if (-not (Test-Path bin)) {
    New-Item -ItemType Directory -Path bin | Out-Null
}

javac -d bin src\App.java src\model\*.java src\repository\*.java src\rules\*.java src\service\*.java
if ($LASTEXITCODE -eq 0) {
    java -cp bin App
}
