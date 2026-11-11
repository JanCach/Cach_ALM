# Projekt ALM – Deník (spojový seznam + seznam nad polem)

Napište deník, ve kterém jde listovat mezi dny a jejich záznamy. Záznamy přidává uživatel.

- **Dny** ukládejte do **vlastního spojového seznamu**.
- **Záznamy dne** ukládejte do **vlastního seznamu (List) postaveného nad polem pevné velikosti**. Počet záznamů na den je neomezený.
- Žádné hotové kolekce jazyka (dynamický seznam, vestavěný spojový seznam…).
- Jazyk i rozhraní (konzole, GUI, web…) si zvolíte sami.
- Den = **datum** (`dd.MM.yyyy`) + seznam záznamů. Záznam = **text** (víceřádkový).

## Operace

| Operace | Co dělá |
|---|---|
| `predchozi` | předchozí den |
| `dalsi` | následující den |
| `zacatek` | první den |
| `konec` | poslední den |
| `novy` | nový záznam (viz níže) |
| `smaz` | smaže vybraný záznam aktuálního dne |
| `uloz` | uloží deník do souboru |
| `nacti` | načte deník ze souboru |
| `zavri` | ukončí program |

## Chování

- Zobrazuje se vždy celý aktuální den s očíslovanými záznamy.
- Uživatel vždy vidí dostupné operace (kromě potvrzování mazání), počet dnů a počet záznamů v aktuálním dni.
- Po spuštění je deník prázdný.
- **novy:** zadání data (při chybném formátu znovu) → text.
    - Datum = aktuální den → záznam se přidá na konec jeho seznamu.
    - Datum mezi aktuálním a následujícím dnem → vznikne nový den za aktuálním.
    - Jinak se zápis odmítne.
- **smaz:** uživatel vybere záznam, program ho zobrazí a vyžádá potvrzení.
    - Den bez záznamů zmizí. Pak se zobrazí následující den, když není, tak předchozí. Prázdný deník = úvodní obrazovka.

## Odevzdání

- Samostatně, odkaz na Git repozitář, termín v Bakalářích.
- README: jazyk a verze, postup spuštění.
- Předvedení na hodině – bez něj se nehodnotí.