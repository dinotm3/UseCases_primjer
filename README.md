# jadrija-zadatak

Aplikacija je testirana na Android 34 emulatoru i trebala bi raditi ispravno na 33+ API. Preporuka je buildati na Android 34

Pri prvom otvaranju aplikacije popis zadataka će biti prazan, na dnu je gumb kojim se otvara popup sa kojim se moze dodavati nove zadatke upisujuči title i content. 
Details page je zamišljen tako da stane dosta contenta tako da se može kopirati duži lorem ipsum u content.

Korištena je MVVM arhitektura uz dodatak UseCaseova koji su korišteni za poslovnu logiku i error handling koji nisam do kraja imao vremena završiti u smislu kompletne custom implementacije preko base klase. 
Klasa UseCase je zamišljena kao Base UseCase klasa iz koje se može naslijediti error handling. Inače bi se dodao custom Error Handling koji bi omogućio lako hendlanje exceptiona. 
Na primjer ako se radi o no internet connection zbog čega korisnika treba obavijestiti onda se automatski generira error message i popunjava prikladan view.
