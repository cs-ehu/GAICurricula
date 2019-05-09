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
                for $c in doc("curriculumEnglandSimp.xml")/curriculums/curriculum
                return
                    <div
                        id="{$c/passport}">
                        <hr></hr>
                        <img
                            src="{data($c/@img)}"
                            alt="{$c/surname}"
                            height="350"
                            width="300"/>
                        <h3>Datos básicos</h3>
                        <strong>-Name and surname: </strong>
                        <br>{data($c/@name-nombre-nom)} {$c/surname}</br>
                        <br></br>
                        <strong>-Birthday: </strong>
                        <br>{data($c/@birthday-fnacimiento-datedenaissance)}</br>
                        <br></br>
                        <strong>-Passport: </strong>
                        {$c/passport}
                        <br></br>
                        <strong>-DriveLicense: </strong>
                        {$c/DriveLicense}
                        <br></br>
                        <strong>-Email: </strong>
                        {$c/email}
                        <br></br>
                        <strong>-Tlp/Mobile: </strong>
                        {$c/mobile, $c/tlp}
                        <h3>Dirección</h3>
                        <strong>country: </strong>
                        <br>{data($c/address/@country-paisOrigen-pays)}</br>
                        <br></br>
                        <strong> CP: </strong>
                        {$c/address/CPIng}
                        <strong> Region: </strong>
                        {$c/address/region}
                        <strong> Province: </strong>
                        {$c/address/province}
                        <br></br>
                        <strong>-City: </strong>
                        {$c/address/city}
                        <br></br>
                        <strong>-Street: </strong>
                        {$c/address/street}
                        <br></br>
                        <strong>-Address: </strong>
                        Portail {$c/addresse/doorway, $c/addresse/apartment}
                        <h3>Idiomas</h3>
                        <strong>-Mothertongues: </strong>
                        {$c/mothertongues}
                        <br></br>
                        <strong>-Foreignlanguages: </strong>
                        <table
                            border="1">
                            <tr>
                                <th>Language</th><th>Level</th>
                            </tr>
                            {
                                for $l in $c/foreignlanguages/lng
                                return
                                    <tr>
                                        <td>{$l/text()}</td><td>{data($l/@level-nivel-niveau)}</td>
                                    </tr>
                            }
                        </table>
                        <h3>Datos erasmus</h3>
                        <strong>-Career: </strong>
                        {$c/career}
                        <br></br>
                        <strong> -Course: </strong>
                        <br>{data($c/career/@course-curso-cours)}</br>
                        <br></br>
                        <strong>-Years studying:</strong>
                        <br>{data($c/career/@yearsstudying-añoscursando-anneesdetudes)}</br>
                        <br></br>
                        <strong> -Erasmus places:</strong>
                        {
                            for $li in $c/erasmusplaces/place
                            return
                                <br>{$li}</br>
                        }
                        <br></br>
                        <strong>-Priority place:</strong>
                        {$c/priorityplace}
                        <br></br>
                        
                        <h3>Habilidades</h3>
                        <h4>Skills</h4>
                        <u>Skill1:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/skill1}
                        <br></br>
                        <u>Skill2:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/skill2}
                        <br></br>
                        <u>Skill3:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/skill3}
                        <br></br>
                         
                        <h4>Aptitudes</h4>
                        <u>Aptitude1:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/aptitude1}
                        <br></br>
                        <u>Aptitude2:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/aptitude2}
                        <br></br>
                        <u>Aptitude3:</u> <strong> ‏‏‎ </strong>{$c/skillsAndAptitudes/aptitude3}
                        <br></br>
                        
                        <h3>Observations</h3>
                        {
                            for $o in $c/obs/child::*
                            return
                            <div>
                                <strong>-{name($o)}: </strong>
                                {$o/text()}
                            </div>
                        }
  
         
                    </div>
            }
        </div>
    </body>
</html>