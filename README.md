### **📝 Enunciado Adaptado: Sistema de Control de Embalses Hídricos (SCEH).**

Una red nacional de gestión de aguas necesita implementar un sistema centralizado que permita registrar y controlar las operaciones de transferencia de agua en sus embalses. Además, el sistema debe permitir que componentes de monitoreo periféricos reaccionen automáticamente a las variaciones en el volumen de agua.

#### **👨‍🏫 Primera Parte \- Control de Operaciones y Excepciones.**

**📋 Requerimientos.**  
**💧 Embalse.**  
De cada embalse en la red se conoce:

* Identificador del Embalse.  
* Volumen de Agua Actual (en hm³ \- hectómetros cúbicos).

Un embalse debe permitir:

* Consultar su volumen actual.  
* Inyectar agua (incrementar hm³).  
* Extraer agua (reducir hm³).

**⚙️ Operaciones de Transferencia.**  
El sistema debe soportar inicialmente las operaciones de **Inyección** y **Extracción**. Cada operación encapsula toda la información necesaria para ejecutarse, conociendo el embalse específico sobre el que actúa y el volumen de agua (hm³) involucrado.  
**📋 Controlador de Operaciones.**  
La plataforma cuenta con un componente responsable de administrar las transferencias. Para esta versión, el componente debe permitir:

* Ejecutar una operación de forma inmediata.  
* Deshacer la última operación ejecutada. Cada operación debe ser capaz de deshacer su propia transformación sobre el embalse.

**⚠️ Manejo de Excepciones y Reglas de Negocio.**  
El sistema debe garantizar la consistencia de los datos modelando correctamente las siguientes situaciones anómalas mediante el uso de excepciones en Java:

1. **Excepción No Verificada (Unchecked Exception) \- Valores Inválidos:** Si se intenta instanciar una operación de Inyección o Extracción con un valor menor o igual a **0 hm³**, el sistema debe lanzar un error que denote un uso indebido de la lógica. Dado que el código cliente no debería generar estas llamadas si está bien programado, el compilador no debe obligar a capturar esta falla explícitamente.  
2. **Excepción Verificada (Checked Exception) \- Nivel de Sequía Crítica:** Se admite una extracción que deje al embalse en un saldo negativo técnico de hasta **\-50 hm³** (agua por debajo del umbral de bombeo normal). Si una extracción intenta forzar al embalse por debajo de este límite absoluto, se debe lanzar un error de regla de negocio. Al ser una situación operativa anómala pero esperable, el diseño debe obligar en tiempo de compilación a que quien invoque la operación se haga cargo de manejar la situación.

**⚙️ Restricciones de Diseño (Primera Parte).**

* El controlador no debe conocer cómo se implementa internamente cada operación.  
* Debe ser posible incorporar nuevos tipos de operaciones sin modificar el código del controlador.  
* Evitar soluciones basadas en condicionales (if / switch) para distinguir tipos de operaciones.

#### **👨‍🏫 Segunda Parte \- Telemetría y Alertas Automáticas.**

La plataforma desea incorporar sistemas periféricos que reaccionen automáticamente a las variaciones del volumen de agua.  
**📢 Mecanismo de Suscripción.**  
Cada vez que un embalse reciba una inyección o extracción exitosa, los sistemas interesados deben ser informados automáticamente. El embalse debe permitir:

* Registrar sistemas interesados de forma dinámica.  
* Eliminar sistemas interesados.  
* Avisar a todos los inscriptos cuando ocurra una variación en el volumen.

Para esta versión, se requiere implementar los siguientes sistemas interesados:

1. **Registro Central de Auditoría:** Registra en un log unificado todas las alteraciones exitosas realizadas sobre los embalses.  
2. **Alarma de Sequía:** Detecta cuándo un embalse queda por debajo de su nivel óptimo (cero hm³) tras una operación exitosa y advierte que se ha ingresado en la zona de saldo técnico negativo.

**⚙️ Restricciones de Diseño (Segunda Parte)**

* El embalse no debe conocer los detalles de las clases concretas de los sistemas periféricos (Auditoría, Alarma, etc.).  
* Debe ser posible incorporar nuevos sistemas interesados sin modificar el código estructural del Embalse.  
* Evitar el uso de condicionales (if / switch / instanceof) en el embalse para identificar a quién se le está avisando.

#### **⏱️ Condiciones de Evaluación**

* **Tiempo máximo de resolución:** 1 hora y 30 minutos reloj.  
* **Metodología:** Desarrollo Guiado por Pruebas (TDD) y refactors sucesivos.  
* **Métrica de éxito:** Se exige alcanzar una cobertura de código (Code Coverage) de al menos un **75%**, demostrando mediante tests el manejo correcto de las excepciones verificadas y no verificadas.