## Megfelelő biztonsági óvintézkedések (authorizáció, SQL injection kivédése, szerver oldali validáció, biztonságos jelszó tárolás stb.)
Úgy néz ki JPA használ egy beépített SQL Injection preventert, de érdemes lenne Controller/Service/Entity rétegben egy Input Validation-t is implementálni ezért implementálok egy @Valid-atort. 

## Linux alatt telepítő csomag készítése
1. wsl home directoryban egy directory-t <name>-<version> módon deffiniálva. Directory-ban 2 aldirectory-t létrehozni, usr/bin és usr/share/ticketsystem.
2. A /ticketsystembe a java-t futtatandó szkript kerül, a /bin a .jar file helye
3. Az egész mappának 'chmod -R 755 .', 'chmod +x usr/bin/ticketsystem'.
4. 'mkdir DEBIAN', 'nano DEBIAN/control'. A controllban a telepítő csomag leírása és dependenciáit kell felsorolni.
5. ~ directoryban 'dpkg-deb --build ticketsystem-1.0'



