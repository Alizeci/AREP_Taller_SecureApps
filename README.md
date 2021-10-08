## Taller de Construcción de una Aplicación Web Segura

Se construye una aplicación web segura que permite evidenciar principios de seguridad como autenticación, autorización e integridad de los usuarios, desde el cliente y en la comunicación entre los servicios a través de sus endpoints públicos.

## Entendimiento 🎯

La aplicación está compuesta de **3 componentes**: un **cliente** (browser), un servicio de **Login** y uno de **Autenticación** corriendo cada uno en una máquina virtual independiente en AWS.

## Descripción Arquitectura ![Descripción detallada](https://img.icons8.com/windows/32/000000/product-architecture.png)

Cada servicio cuenta con un certificado propio, y el servicio **LoginService** cuenta con *autorización* para hacer una solicitud *GET* a **AuthService** para autenticar el usuario y darle la bienvenida a la página web segura. Se maneja una comunicación segura a través de **https**.

### Diseño de la arquitectura de la aplicación 📝

<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <img src="https://github.com/Alizeci/AREP_Taller_SecureApps/blob/main/img/arquitecturaBasica.png" alt="AG" width="800"/>
    </body>
</html>

+ El **Cliente,** a través de quien se realizará las solitudes de autenticación sobre el servicio **LoginService**. Nuestra máquina local a través de un browser.

+ La aplicación web **LoginService** corre por el puerto **4567**. 
  
  📍**Tiene 1 endpoint:** 
  + **GET** */auth*, que permite recibir el username y password del usuario, revisando la completitud de los parámetros (credenciales) requeridos para luego consumir el **AuthService** y finalmente autenticar el usuario.

+ La aplicación web **AuthService** corre por el puerto **4500**. 
  
  📍**Tiene 1 endpoint:** 
  + **GET** */auth*, recibe las credenciales y valida con el *único usuario autorizado* el **acceso** a este. Retorna un mensaje de login y autenticación exitoso seguido de una bienvenida con el nombre del usuario.

## Escalar la arquitectura de seguridad para incorporar nuevos servicios ![despliegue](https://img.icons8.com/plasticine/45/000000/services.png)

## Herramientas utilizadas

| Nombre | Uso |
| ------ | ------ |
| **Maven** ![Maven](https://img.icons8.com/ios/25/000000/maven-ios.png) | Gestión y construcción del proyecto |
| **Eclipse IDE** ![Eclipse](https://img.icons8.com/office/25/000000/java-eclipse.png) | Plataforma de desarrollo |
| **Git** ![Git](https://img.icons8.com/color/25/000000/git.png) | Sistema de control de versiones |
| **Github** ![Github](https://img.icons8.com/windows/25/000000/github.png) | Respositorio del código fuente |
| **Docker & DockerHub** [![Docker](https://img.icons8.com/color/48/000000/docker.png)](https://hub.docker.com) | Contrucción de los contenedores |
| **Amazon Web Services** [![AWS](https://img.icons8.com/color/48/000000/amazon-web-services.png)](https://aws.amazon.com/training/awsacademy/) | Plataforma de producción en la nube |

## Autor ![Autor](https://img.icons8.com/fluency/30/000000/person-female.png)
Laura Alejandra Izquierdo Castro
