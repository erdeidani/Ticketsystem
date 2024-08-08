# ticketSystem
Alap feladatok (maximális kapható pontokkal):

- [x] 7p: REST API (benne új adat létrehozása, lekérdezés, adat módosítása, logikusan felépített URL-ekkel)
    -kontrollerek által kiajánlott api, amit a serviceken kerüsztül levezetünk a data rétegbe az entittykhez, 
    vágül a repositorik kezelik le az adatbázis műveleteket (Spring Data) 
    
- [x] 8p: Több felhasználó, az authentikáció és különböző szerepkörök támogatása.
   - Spring Security, még utána kell néznem *User entity?*     
   
- [ ] 5p: _Aszinkron üzenetsorral kommunikáló szerverek (vagyis több backend komponens van)._    
   - nem feltétlen nehéz elgondolkodhatunk rajta, de inkább csak 2. szintű, nem prioritás   
   
- [x] 5p: Java Persistence API használata, legalább 5 osztállyal.
   - easy, az eddigi osztályoknak megfelelően kell létrehozni entityket, *hiányzik 2-3 darab hogy meg legyen az 5*   
     
- [x] 2p: Spring Data használata    
   - kész , JPA repository használata
   - minden *Entityhez legyen Repository is* a mintána megfelelően
  
- [x] 3p: Függőséginjektálás Spring alapokon
  - kész , bármilyen osztály teljesíti amiben konstruktor / @Autowired dependency injection van   
  
- [x] 5p: Megfelelő biztonsági óvintézkedések (authorizáció, SQL injection kivédése, szerver oldali validáció, biztonságos jelszó tárolás stb.)
   - ez kéne mert valszeg nem annyira nehéz, plusz hasznos lenne ismerni,   
   - még nem látom mi lesz a pontos feladat, valszeg kellenek role-ok   
   
- [ ] 2p: Unit tesztek használata (Jelentős lefedettség esetén további bónusz pontokat ér.)
  - könnyen tanulható én kigrindolnám, 80-90% felett lehet nem érdemes lefedni, de ha nincs jobb dolgunk megpróbálhatjuk
   
- [x] 3p: Logolási mechanizmus használata loglevel támogatással.
  - easy igazából a Springben van beépített log, és nincs mennyiségi követelmény, plusz a logolást jó megtanulni jól 
    használni, illetve a debbugoolást is nagyban megkönnyíti

Pluszok nélkül: 30 pont, Plusz feladatokkal: 40 pont (Üzenetsor, Biztonság)

Bónusz feladatok, melyek plusz utánajárást is igényelhetnek (maximális kapható pontokkal, csak ha az alap feladatokból időben leadva legalább 30 pont összegyűlt):
- [x] 5p: Linux alatt telepítő csomag készítése
  - értelmes, hasznos
- [ ] 5p: Időzített taskok a backendben.
  - meh
- [ ] 5p: E-mail küldés a backendben.
  - gyanúsan easy
- [ ] 3-10p: Jelentős automatikus teszt lefedettség, lefedettségtől függően pontozva   
  - grindolható
  
- [ ] 8p: Induláskor lefutó öntesztelő funkció megvalósítása, mely a rendszer minden komponensének elérhetőségét és alapvető funkcióinak működőképességét teszteli (pl. webes felületről egy adat elmentése adatbázisba, majd visszaolvasása, hardver periféria megszólítása, valamint a vastag kliensen a logba írás).   
   - ez nem tom mi de érdekesnek hangzik, v


