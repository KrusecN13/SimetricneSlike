# Vsebinski načrt:

Aplikacija Simetrične slike je napisala v programskem jeziku Java s pomočjo urejevalnika Eclipse. 

## Razredi:
Vsi razredi so skupaj v paketu (package) GUI.

### Razred Zazeni:
V razredu Zazeni lahko aplikacijo zaženemo.

### Razred GlavnoOkno:
V razredu Glavno Okno so vse funkcije za izgled aplikacije. Okno vsebuje platno, na katerega uporabnik riše ter gumbi, ki so povezani z različnimi funkcijami.

### Razred Platno:
V razredu Platno so zapisane vse funkcije, ki so povezane z gumbi.
Na desni strani aplikacije so vse možnosti razdeljene na tri dele: simetrije, slikar in platno.

#####Simetrije:
V aplikaciji je možno izbirati med različnimi simetrijami. Možnosti so simetrija čez x os, čez y os in čez koordinatno izhodišče, katerega izhodišče se nahaja v sredini platna. 
Koordinatni sistem je nastavljen v središče s pomočjo metode Koordinate. 

#####Slikar:
Pri risanju je možno izbirati med različnimi barvami, za bolj raznolike slike. Uporabnik izbira med barvami tako, da klikne na gumb z željeno barvo.
Poleg tega lahko izbiramo tudi debelino črte. Če kliknemo na gumb svičnik rišemo s tanko črto, če kliknemo na gumb čopič pa rišemo z debelejšo črto, katere debelino lahko nastavljamo s pomočjo gumba + in -.

#####Platno:
Ob strani aplikacije imamo še nekaj dodatnih možnosti.
Ko sliko narišemo, jo lahko shranimo, če kliknemo na gumb shrani. Odpre se nam okno, kjer zberemo mapo v kateri želimo imeti to sliko.
Poleg tega lahko sliko zbrišemo in začnemo ponovno s pomočjo gumba zbriši.
Če uporabniku ne ustrezata privzeta višina in širina platna se lahko nastavita. V prostor, kjer piše višina in širina vpišemo želene dimenzije, za tem pa kliknemo na gumb novo platno. 

Aplikacija se zapre, ko kliknemo na x - v desnem zgornjem kotu.
### Razred Krogec in razred Crte:
V aplikaciji je možno risati z različno debelino. Če izberemo gumb svinčnik, rišemo s tanko črto, ki je implementirana v razredu Crte. 
Če izberemo gumb čopič, lahko nastavljamo debelino črte z gumboma + in -. Možnost čopič je implementirana s pomočjo razreda Krogec.


