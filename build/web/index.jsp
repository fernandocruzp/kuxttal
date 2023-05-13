<%-- 
    Document   : index
    Created on : 19/11/2021, 04:18:22 PM
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Inicio | Kuxttal</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="Css/indexCSS.css">
        <link rel="icon" href="IMG/icon.png" type="image/x-icon">
    </head>

    <body>
        <header>

            <div class="menu">
                <nav>
                    <p id="nom" align="left">K&nbsp;U&nbspX&nbspT&nbspT&nbspA&nbspL</p>
                    <ul>
                        <li><a href="Registro.jsp">Registro</a></li>
                        <li><a href="InicioSesion.jsp">Inicio de sesión</a></li>
                        <li><a href="#servicios">Conócenos</a></li>
                        <li><a href="#servicios">Acerca de</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div class="contenedor">

            <div class="slider-contenedor">

                <section class="contenido-slider">
                    <div class="sizeD">
                        <h1 class="s1">¿Cómo   KUXTTAL  cambia    el  seguimiento  clínico?</h1>
                        <center><a href="#">Comienza ahora</a></center>
                    </div>
                </section>

                <section class="contenido-slider">
                    <div class="sizeD">
                        <h2 class="s1">Útil para cualquier especialidad médica.</h2>
                    </div>
                </section>

                <section class="contenido-slider">
                    <div>
                        <h2 id="nuevo">Para &nbsp las &nbsp nuevas &nbsp condiciones &nbsp del &nbsp mundo.</h2>
                    </div>
                </section>

                <section class="contenido-slider">
                    <div class="sizeD">
                        <h1 class="s1">¿Cómo   KUXTTAL  cambia    el  seguimiento  clínico?</h1>
                        <center><a href="Registro.jsp">Comienza ahora</a></center>
                    </div>
                </section>

            </div>
        </div>
        <br>
        <br>
        <br>
        <br>

        <h1 id="servicios" align="center">Servicios Kuxttal<span class="point">.</span></h1>

        <div class="flex-container">
            <div><br>
                <p align="center" ><img class="icons" src="IMG/chat-movil.png"><br/><br/>
                    <b>Comunícate</b><br/><br/><!--
                Información veraz y oportuna sobre la COVID-19 y la vacunación.--></p>
            </div>

            <div><br>
                <p align="center" ><img class="icons" width="250px" src="IMG/lapiz.png">
                    <br/><br/>
                    <b>Haz tus notas</b><br/><br/><!--
                    Apartado de notas individuales.--></p>
            </div>

            <div><br>
                <p align="center" ><img class="icons" width="250px" src="IMG/bitacora.png">
                    <br/><br/>
                    <b>Monitorea todo</b><br/><br/> <!--
                    Lleva un registro para monitoreo de evolución y signos vitales.--></p>
            </div>

            <div><br>
                <p align="center" ><img class="icons" width="250px" src="IMG/cardiologo.png">
                    <br/><br/>
                    <b>Mantente conectado</b><br/><br/><!--
                    Mantén comunicación contínua con los médicos con quienes acudes.--></p>
            </div>


        </div>
        <p id="marktg" align="center">Con esta plataforma tienes eso y más.</p>
        <br><br><br>

        <section class="services">
            <div class="containerr">
                <section class="projects containerr">
                    <h2 class="subtitle">Contenido adicional<span class="point">.</span></h2>
                    <p class="copy__section">Además de sus funciones principales, Kuxttal te ofrece otros beneficios.</p>
                    <article class="containerr-bg">
                        <div class="card">
                            <div class="cards__text">
                                <h3 class="card__title">Informaión sobre COVID-19<span class="point">.</span></h3>
                                <p class="card__date">Próximamente.</p>
                                <p class="card__copy">Ofrecemos un apartado lleno de información sobre la COVID-19, la vacunación y demás cuestiones sobre la pandemia, toda recabada de diversos portales de las más reconocidas organizaciones como la OMS, la OPS, los CDC, entre otros.</p>
                                <a href="#" class="card__button">Ir ahora</a>
                            </div>
                        </div>
                        <div class="background">
                            <img src="IMG/bck1.jpg" class="background__img">
                            <div class="background__text">
                                <h3 class="background__title">Infórmate<span class="point">.</span></h3>
                                <p class="background__copy">Mantente informado, continúa cuidándote y no bajes la guardia.</p>
                            </div>
                        </div>
                        <div class="card">
                            <div class="cards__text">
                                <h3 class="card__title">Test de agudeza visual<span class="point">.</span></h3>
                                <p class="card__date">Próximamente.</p>
                                <p class="card__copy">Como nuestra prioridad es tu bienestar, aquí podrás encontrar un examen de la vista online. Este enlace te llevará al portal oficial de ZEISS® donde podrás valorar tu nivel de agudeza visual.</p>
                                <a href="https://visionscreening.zeiss.com/es-MX" class="card__button">Ir ahora</a>
                            </div>
                        </div>
                        <div class="background">
                            <img src="IMG/background2.jpg" class="background__img">
                            <div class="background__text">
                                <h3 class="background__title">Valora tu visión<span class="point">.</span></h3>
                                <p class="background__copy">Recibe una estimación de cuán agudo es el más importante de tus sentidos.</p>
                            </div>
                        </div>
                    </article>
                </section>
                <footer class="pie-pagina">
                    <div class="grupo-2">
                        <small>&copy; 2021-2022 <b>Fénix Inc.</b> - Todos los Derechos Reservados.</small>
                    </div>
                </footer>

                <!--Scripts-->
                <script src="JS/main.js"></script>
                </body>

                </html>