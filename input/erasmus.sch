<?xml version="1.0" encoding="UTF-8"?>
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2"
    xmlns:sqf="http://www.schematron-quickfix.com/validator/process">
    
    <sch:pattern id="DatosDiferentes">
        <sch:p>Hay datos que no pueden estar repetidos.</sch:p> 
        <sch:rule context="curriculums">
            <sch:assert test="count(./curriculum/email) = count(distinct-values(./curriculum/email))" diagnostics="EmailRep">
                Los emails no pueden estar repetidos.
            </sch:assert>
            
            <sch:assert test="count(./curriculum/movil) = count(distinct-values(./curriculum/movil))" diagnostics="MovRep">
                Los moviles no pueden estar repetidos.
            </sch:assert>
        </sch:rule>
    </sch:pattern>
    
    <sch:pattern id="AñosCarreraIncorrectos">
        <sch:p>Error en los años.</sch:p> 
        <sch:rule context="curriculums/curriculum">
            <sch:assert test="./grado/@course-curso-cours &gt;= 2" diagnostics="DosCur">
                El alumno <sch:value-of select="./@name-nombre-nom"/> no ha cursado años suficientes.
            </sch:assert>
            
            <sch:assert test="./grado/@course-curso-cours &lt;= 5" diagnostics="CincoCur">
                El alumno <sch:value-of select="./@name-nombre-nom"/> no puede tener un curso mayor a 5.
            </sch:assert>
            
            <sch:assert test="./grado/@yearsstudying-añoscursando-anneesdetudes &gt;= ./grado/@course-curso-cours" diagnostics="CursandoCursoIn">
                El alumno <sch:value-of select="./@name-nombre-nom"/> no puede estar cursando menos años que el curso en el que se encuentra.
            </sch:assert>
        </sch:rule>
        
        <sch:rule context="curriculums/curriculum/grado[@course-curso-cours = 5]">
            <sch:assert test="contains(., 'Arquitectura') or contains(., 'Medicina')" diagnostics="InCur">
                El alumno <sch:value-of select="./../@name-nombre-nom"/> tiene un grado con menos cursos.
            </sch:assert>
        </sch:rule>
    </sch:pattern>
    
    <sch:pattern id="LenguaMaternaDiferenteALenguaExt">
        <sch:p>La lengua materna no puede estar entre las extranjeras.</sch:p> 
        <sch:rule context="curriculums/curriculum/lenguasextranjeras/Lng">
            <sch:assert test="contains(., ../../lenguajematerno/data()) = false()" diagnostics="IdiomaIn">
                El alumno <sch:value-of select="../../@name-nombre-nom"/> no puede tener un idioma materno igual a uno extranjero.
            </sch:assert>
        </sch:rule>
    </sch:pattern>
    
    <sch:pattern id="LenguasExtranjeras">
        <sch:p>Error en las lenguas.</sch:p> 
        <sch:rule context="curriculums/curriculum/lenguasextranjeras">
            <sch:assert test="count(distinct-values(./Lng/data())) = count(./Lng/data())" diagnostics="IdiomaRep">
                El alumno <sch:value-of select="../@name-nombre-nom"/> no puede tener idiomas extranjeros repetidos.
            </sch:assert>
        </sch:rule>
        <sch:rule context="curriculums/curriculum">
            <sch:assert test="count(.//Lng[./data() = 'Castellano']) = 1" diagnostics="IdiomaEsp">
                El alumno <sch:value-of select="../@name-nombre-nom"/> debe saber castellano para hacer el erasmus en España.
            </sch:assert>
        </sch:rule>
        <sch:rule context="curriculums/curriculum/lenguasextranjeras/Lng[./data() = 'Castellano']">
            <sch:assert test="contains(./@level-nivel-niveau, 'B2') or contains(./@level-nivel-niveau, 'C1') or contains(./@level-nivel-niveau, 'C2')" diagnostics="NvEsp">
                El alumno <sch:value-of select="../@name-nombre-nom"/> tiene que tener castellano de nivel B2.
            </sch:assert>
        </sch:rule>
    </sch:pattern>
    
    <sch:diagnostics>
        <sch:diagnostic id="EmailRep">
            Error de entidad, existen dos o más emails repetidos.
        </sch:diagnostic>
        <sch:diagnostic id="MovRep">
            Error de entidad, existen dos o más moviles repetidos.
        </sch:diagnostic>
        <sch:diagnostic id="DosCur">
            Error en los años cursados, años insuficientes.
        </sch:diagnostic>
        <sch:diagnostic id="InCur">
            Error en el grado, para tener 5 cursos debes ser de Arquitectura o Medicina.
        </sch:diagnostic>
        <sch:diagnostic id="CincoCur">
            Error en el grado, no existe un grado con más de 5 cursos.
        </sch:diagnostic>
        <sch:diagnostic id="CursandoCursoIn">
            Error en el grado, no hay nadie cursando menos años que su curso.
        </sch:diagnostic>
        <sch:diagnostic id="IdiomaIn">
            Error en el idioma, coincidencia en idiomas.
        </sch:diagnostic>
        <sch:diagnostic id="IdiomaRep">
            Error en los idiomas, los idiomas extranjeros no pueden coincidir.
        </sch:diagnostic>
        <sch:diagnostic id="IdiomaEsp">
            Error en los idiomas, el alumno debe saber castellano.
        </sch:diagnostic>
        <sch:diagnostic id="NvEsp">
            Error en los idiomas, el alumno debe saber castellano con nivel B2.
        </sch:diagnostic>
    </sch:diagnostics>
</sch:schema>