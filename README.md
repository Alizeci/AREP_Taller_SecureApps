## Taller de Construcción de una Aplicación Web Segura

Se construye una aplicación web segura que permite evidenciar principios de seguridad como autenticación, autorización e integridad de los usuarios, desde el cliente y en la comunicación entre los servicios a través de sus endpoints públicos.

## Entendimiento 🎯

La aplicación está compuesta de **3 componentes**: un **cliente** (browser), un servicio de **Login** y uno de **Autenticación** corriendo cada uno en una máquina virtual independiente en AWS.

## Descripción Arquitectura ![Descripción detallada](https://img.icons8.com/windows/32/000000/product-architecture.png)

Cada servicio cuenta con un certificado propio, y el servicio **LoginService** cuenta con *autorización* para hacer una solicitud *GET* a **AuthService** para autenticar el usuario y darle la bienvenida a la página web segura. Se maneja una comunicación segura a través de **https**. 

Adicionalmente se maneja una encriptación para aumentar la seguridad de la contraseña, con **SHA-256** en la comunicación.

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

La arquitectura se puede escalar por medio de la **generación de certificados propios** de los nuevos servicios y la *inclusión del certificado* del nuevo servicio el archivo myTrustStore, para *autorizar el acceso* desde la que recibimos las credenciales, en el directorio de los certificados autorizados de LoginService. Así como **conectando un endpoint** del servicio principal para consumir el nuevo.

**1. Usando los siguientes comandos poder generar, un par de llaves públicas y privadas y un certificado. Y los almacenamos todo en un archivo protegido. Se hace uso del formato PKCS12, un formato estándar para almacenar llaves y certificados.**

```sh
keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
```
> Nota: usamos “localhost” o "url de la aplicación desplegada en aws" como nombre del certificado cuando se lo pida la herramienta.

**2. Exportamos el certificado a un archivo**
```sh
keytool -export -keystore ./ecikeystore.p12 -alias ecikeypair -file ecicert.cer
```

**3. Finalmente, importamos el certificado a un myTrustStore**
```sh
keytool -import -file ./ecicert.cer -alias firstCA -keystore myTrustStore
```

Adicionalmente, aunque se realizó el ejercicio con las mejores prácticas de clean code y las **aplicaciones de 12 factores** posibles, algunas de ellas quedan por fuera para efecto de la práctica, pero para escalarla deben tenerse en cuenta:

**La aplicación de 12 factores** es una metodología para construir aplicaciones de software como servicio.

**Algunas de ellas incluyen:**
+ Almacenar la configuración en el entorno de la aplicación, **variables de entorno**. No dejarlas como constantes en el código.
+ **Manejadores de recursos para la base de datos**, Memcached y otros servicios de respaldo Credenciales para servicios externos como Amazon S3 o Twitter
+ **Valores por despliegue** como el nombre de host canónico para el despliegue.
+ Utilizar **formatos declarativos** para la automatización de la configuración, con el fin de minimizar el tiempo y el coste para los nuevos desarrolladores que se incorporen al proyecto.
+ Tener un **contrato limpio** con el sistema operativo subyacente, ofreciendo la **máxima portabilidad** entre entornos de ejecución.
+ Hacer la aplicación apta para el **despliegue** en plataformas de **nube modernas**, obviando la necesidad de servidores y administración de sistemas.
+ **Minimizar la divergencia** entre desarrollo y producción, permitiendo el **despliegue continuo** para una máxima agilidad.
+ **Escalar** sin cambios significativos en las herramientas, la arquitectura o las prácticas de desarrollo.

Finalmente agregando una **base de datos** para almacenar las credenciales con el hash de la contraseña se puede escalar eficientemente, de momento solo tiene un único usuario, quemado en código.

## ![AWS](https://img.icons8.com/color/38/000000/amazon-web-services.png) Video experimental en AWS

Se puede encontrar a continuación [ver video](https://github.com/Alizeci/AREP_Taller_SecureApps/blob/main/awsTestVideo.mp4)
    
## Herramientas utilizadas

| Nombre | Uso |
| ------ | ------ |
| **Maven** ![Maven](https://img.icons8.com/ios/25/000000/maven-ios.png) | Gestión y construcción del proyecto |
| **Eclipse IDE** ![Eclipse](https://img.icons8.com/office/25/000000/java-eclipse.png) | Plataforma de desarrollo |
| **Git** ![Git](https://img.icons8.com/color/25/000000/git.png) | Sistema de control de versiones |
| **Github** ![Github](https://img.icons8.com/windows/25/000000/github.png) | Respositorio del código fuente |
| **Amazon Web Services** [![AWS](https://img.icons8.com/color/48/000000/amazon-web-services.png)](https://aws.amazon.com/training/awsacademy/) | Plataforma de producción en la nube |

## Autor ![Autor](https://img.icons8.com/fluency/30/000000/person-female.png)
Laura Alejandra Izquierdo Castro
