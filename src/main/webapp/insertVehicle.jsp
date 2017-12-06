<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserisci veicolo</title>
    </head>
    <body>
        <h1>Menu Veicolo</h1>
        <p><i>Inserisci i seguenti dati</i></p>
        <form action="****Insert Vehicle****" method="post"><br>
            Inserisci il brand <input type="text" name="brand"><br>
            Inserisci il modello <input type="text" name="modello"><br>
            Inserisci tipo alimentazione<input type="text" name="alimentazione"><br>
            Inserisci versione <input type="text" name="versione"><br>
            Inserisci la cilindrata <input type="text" name="cilindrata"><br>
            <input type="submit" name="submit" value="inserisci"><br>

        </form>
    </body>
</html>
