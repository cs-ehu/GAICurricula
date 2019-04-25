<html>
    <title>Curriculums erasmus</title>
    <head>
        <h1>Curriculums erasmus</h1>
    </head>
    <body>
        <h2>Curriculums franceses</h2>
        <!-- Importante cambiar en Java el filename de doc por su absoluta "input/loquesea.xml" -->
        <div
            id="curFran">
            {
                for $c in doc("curriculumFranceSimp.xml")/curriculums/curriculum
                return
                    <div
                        id="{$c/CNI}">
                        <hr></hr>
                        <img
                            src="{data($c/@img)}"
                            alt="{$c/prenom}"
                            height="350"
                            width="300"/>
                        <h3>Datos básicos</h3>
                        <strong>-Nom et prénom: </strong>
                        <br>{data($c/@name-nombre-nom), $c/prenom}</br>
                        <br></br>
                        <strong>-Date De Naissance: </strong>
                        <br>{data($c/@birthday-fnacimiento-datedenaissance)}</br>
                        <br></br>
                        <strong>-Passeport: </strong>
                        {$c/passeport}
                        <br></br>
                        <strong>-CNI: </strong>
                        {$c/CNI}
                        <br></br>
                        <strong>-Email: </strong>
                        {$c/email}
                        <br></br>
                        <strong>-Tlf/Mobile: </strong>
                        {$c/mobile, $c/tlfne}
                        <h3>Dirección</h3>
                        <strong>Pays: </strong>
                        <br>{data($c/addresse/@country-paisOrigen-pays)}</br>
                        <br></br>
                        <strong> CP: </strong>
                        {$c/addresse/CPFr}
                        <strong> Region: </strong>
                        {$c/addresse/region}
                        <strong> Province: </strong>
                        {$c/addresse/province}
                        <br></br>
                        <strong>-Ville: </strong>
                        {$c/addresse/ville}
                        <br></br>
                        <strong>-Rue: </strong>
                        {$c/addresse/rue}
                        <br></br>
                        <strong>-Addresse: </strong>
                        Portail {$c/addresse/portail, $c/addresse/appartement}
                        <h3>Idiomas</h3>
                        <strong>-Langue maternelle: </strong>
                        {$c/languematernelle}
                        <br></br>
                        <strong>-Langue etrangeres: </strong>
                        <table
                            border="1">
                            <tr>
                                <th>Langue</th><th>Niveau</th>
                            </tr>
                            {
                                for $l in $c/languesetrangeres/lng
                                return
                                    <tr>
                                        <td>{$l/text()}</td><td>{data($l/@level-nivel-niveau)}</td>
                                    </tr>
                            }
                        </table>
                        <h3>Datos erasmus</h3>
                        <strong>-Carriere: </strong>
                        {$c/carriere}
                        <br></br>
                        <strong> -Cours: </strong>
                        <br>{data($c/carriere/@course-curso-cours)}</br>
                        <br></br>
                        <strong>-Annees de tudes:</strong>
                        <br>{data($c/carriere/@yearsstudying-añoscursando-anneesdetudes)}</br>
                        <br></br>
                        <strong> -Erasmus endroits:</strong>
                        {
                            for $li in $c/erasmusendroits/lieu
                            return
                                <br>{$li}</br>
                        }
                        <br></br>
                        <strong>-Lieu prioritaire:</strong>
                        {$c/lieuprioritaire}
                        <br></br>
                        <h3>Datos acádemicos/laborales</h3>
                        <h4>Travails</h4>
                        {
                            for $t in $c/travail/occupation
                            return
                                <div>
                                    <strong>-Poste:</strong>
                                    <br>{data($t/@poste)}</br>
                                    <br></br>
                                    <strong> -Type de travail:</strong>
                                    <br>{data($t/@typedetravail)}</br>
                                    <br></br>
                                    <strong> -Lieu de travail:</strong>
                                    <br>{data($t/@lieudetravail)}</br>
                                    <br></br>
                                    <strong>-Periodo:</strong>
                                    ({$t/datededébut}, {$t/datedefin})
                                    <strong> -Entreprise: </strong>
                                    {$t/entreprise}
                                    <br></br>
                                    <strong>-Descripción: </strong>
                                    {$t/description}
                                    <br></br>
                                    <strong>-Temps con sacré/Produit: </strong>
                                    {$t/tempsconsacré, $t/produit}
                                </div>
                        }
                        <h4>Meilleure notes</h4>
                        <table
                            border="1">
                            <tr>
                                <th>Code etudiant</th><th>Cours</th><th>Note moyenne</th>
                            </tr>
                            {
                                for $n in $c/notes/meilleurenote
                                return
                                    <tr>
                                        <td>{$n/codeetudiant}</td><td>{data($n/@cours)}</td><td>{$n/notemoyenne}</td>
                                    </tr>
                            }
                        </table>
                        <h4>Realisation</h4>
                        {
                            for $r in $c/realisation/realisationatteint
                            return
                                <br>{$r}</br>
                        }
                        <hr></hr>
                    </div>
            }
        </div>
    </body>
</html>