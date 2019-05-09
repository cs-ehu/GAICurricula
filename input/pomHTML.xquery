<html>
    <title>MAVEN GAICurricula</title>
    <head>
        <h1>GAICurricula</h1>
    </head>
    <body>
        <h3>Artefacto</h3>
        {
                for $p in doc("pom.xml")/project
                return
                    <div id="all-page">
                        <div id="artifact">
                            <strong>-Id del grupo: </strong>
                            <br>{$p/groupId}</br>
                            <br></br>
                            <strong>-Id del artefacto: </strong>
                            <br>{$p/artifactId}</br>
                            <br></br>
                            <strong>-Versión: </strong>
                            <br>{$p/version}</br>
                            <br></br>
                            <strong>-Packaging: </strong>
                            <br>{$p/packaging}</br>
                            <br></br>
                        </div>
                        <h3>Datos del proyecto</h3>
                        <div id="proyect-data">
                            <strong>-Nombre del proyecto: </strong>
                            <br>{$p/name}</br>
                            <br></br>
                            <strong>-URL: </strong>
                            <a href="{$p/url}"> Visitar URL del proyecto </a>
                            <br></br>
                            <strong>-Codificación del proyecto: </strong>
                            <br>{$p/properties/project.build.sourceEncoding}</br>
                        </div>
                        <h3>Dependencias del proyecto</h3>
                        <div id="dependencies">
                            <table border="1">
                                <tr>
                                    <th>Id del grupo</th><th>Id del artefacto</th><th>Versión</th>
                                </tr>                            
                                {
                                    for $d in $p/dependencies/dependency
                                    return
                                    <tr>
                                      <td>{$d/groupId}</td><td>{$d/artifactId}</td><td>{$d/version}</td>
                                    </tr>
                                }
                            </table>
                        </div>
                        <h3>Plugins del proyecto</h3>
                        <div id="plugins">
                             <table border="1">
                                <tr>
                                    <th>Id del grupo</th><th>Id del artefacto</th>
                                </tr>                            
                                {
                                    for $pl in $p/build/pluginManagement/plugins/plugin
                                    return
                                    <tr>
                                      <td>{$pl/groupId}</td><td>{$pl/artifactId}</td>
                                    </tr>
                                }
                            </table>
                        </div>
                    </div>
        }
    </body>
</html>