;This file will be executed next to the application bundle image
;I.e. current directory will contain folder Anglictina vyukovy program with application files
[Setup]
AppId={{Main}}
AppName=Angliètina výukový program
AppVersion=1.0
AppVerName=Anglictina vyukovy program 1.0
AppPublisher=Mgr. Zuzana Vaøáková, Jakub Míl, Bc. Jan Vaòura
AppComments=Anglictina vyukovy program
AppCopyright=
AppPublisherURL=http://www.anglictina-vyukovy-program.cz
AppSupportURL=http://www.anglictina-vyukovy-program.cz/files/help.pdf
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\Anglictina vyukovy program
DisableStartupPrompt=Yes
DisableDirPage=No
DisableProgramGroupPage=Yes
DisableReadyPage=No
DisableFinishedPage=No
DisableWelcomePage=No
DefaultGroupName=Mgr. Zuzana Vaøáková, Jakub Míl, Bc. Jan Vaòura
;Optional License
LicenseFile=
;WinXP or above
WizardImageFile=aside.bmp
MinVersion=0,5.1 
OutputBaseFilename=anglictina_vyukovy_program_instalace
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=Anglictina vyukovy program\Anglictina vyukovy program.ico
UninstallDisplayIcon={app}\Anglictina vyukovy program.ico
UninstallDisplayName=Anglictina vyukovy program
WizardImageStretch=No
WizardSmallImageFile=Anglictina vyukovy program-setup-icon.bmp   

[Languages]
Name: "czech"; MessagesFile: "compiler:Languages\Czech.isl"

[Files]
Source: "Anglictina vyukovy program\Anglictina vyukovy program.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Anglictina vyukovy program\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\Anglictina vyukovy program"; Filename: "{app}\Anglictina vyukovy program.exe"; IconFilename: "{app}\Anglictina vyukovy program.ico"; Check: returnTrue()
Name: "{commondesktop}\Anglictina vyukovy program"; Filename: "{app}\Anglictina vyukovy program.exe";  IconFilename: "{app}\Anglictina vyukovy program.ico"; Check: returnTrue()

[Run]
Filename: "{app}\Anglictina vyukovy program.exe"; Description: "{cm:LaunchProgram,Anglictina vyukovy program}"; Flags: nowait postinstall skipifsilent

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
