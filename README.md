# SportsPredictor - Sistema de Pronósticos Deportivos

## Descripción del Sistema

SportsPredictor es un sistema que permite a los usuarios realizar pronósticos en eventos deportivos de diversas disciplinas. Los usuarios pueden ver calendarios de eventos, equipos participantes, estadísticas y realizar pronósticos en diferentes categorías como resultado del partido, marcador exacto o rendimiento de jugadores.

## Patrones de Diseño Implementados

### 1. Factory Method (Creacional)

**Problema resuelto**: Creación compleja de objetos para diferentes tipos de pronósticos y notificaciones.

**Implementación**:
- `IPronosticoFactory`: Interfaz para crear diferentes tipos de pronósticos
- `PronosticoFactory`: Implementación que crea pronósticos de resultado, marcador y rendimiento
- `INotifierFactory`: Interfaz para crear diferentes tipos de notificadores
- `NotifierFactory`: Implementación que crea notificadores de email, SMS y push

**Beneficios**:
- Flexibilidad para agregar nuevos tipos sin modificar código existente
- Encapsulación de la lógica de creación
- Facilita testing y mantenimiento

### 2. Adapter (Estructural)

**Problema resuelto**: Integración de sistemas externos con interfaces incompatibles (APIs deportivas).

**Implementación**:
- `IDeporteAPI`: Interfaz común para todas las APIs deportivas
- `FutbolAPIAdapter`: Adapta la API externa de fútbol al formato interno
- `BaloncestoAPIAdapter`: Adapta la API externa de baloncesto al formato interno

**Beneficios**:
- Permite integrar nuevos proveedores sin cambiar código principal
- Facilita testing con implementaciones mock
- Mantiene consistencia en la interfaz interna

### 3. State (Comportamental)

**Problema resuelto**: Estados complejos de pronósticos con comportamientos diferentes y transiciones complejas.

**Implementación**:
- `IPronosticoState`: Interfaz para todos los estados de pronóstico
- `PronosticoPendienteState`: Estado inicial del pronóstico
- `PronosticoAcertadoState`: Estado cuando el pronóstico es correcto
- `PronosticoFallidoState`: Estado cuando el pronóstico es incorrecto
- `PronosticoEnRevisionState`: Estado cuando el pronóstico está siendo revisado

**Beneficios**:
- Elimina cadenas de if-else para manejar estados
- Facilita agregar nuevos estados y comportamientos
- Centraliza la lógica de transiciones
- Mejora legibilidad y mantenibilidad

### 4. Chain of Responsibility (Comportamental)

**Problema resuelto**: Escalamiento flexible de incidencias a través de diferentes niveles de soporte.

**Implementación**:
- `IIncidenciaHandler`: Interfaz para todos los handlers de incidencias
- `AbstractIncidenciaHandler`: Clase abstracta con funcionalidad común
- `MiembroSoporteHandler`: Procesa incidencias simples
- `MiembroQCHandler`: Procesa incidencias complejas
- `AdministradorHandler`: Procesa cualquier incidencia como último recurso
- `IncidenciaService`: Configura y gestiona la cadena de responsabilidad

**Beneficios**:
- Flexibilidad para agregar nuevos niveles de soporte
- Cada handler tiene una responsabilidad específica
- Fácil modificación de reglas de escalamiento
- Desacoplamiento entre niveles de soporte

## Estructura del Proyecto

```
src/main/java/com/sportspredictor/
├── model/                    # Entidades del dominio
│   ├── Pronostico.java      # Clase principal con patrón State
│   ├── Incidencia.java      # Entidad para incidencias
│   ├── Usuario.java         # Usuario del sistema
│   └── ...
├── service/                  # Servicios y patrones implementados
│   ├── Factory Method/
│   │   ├── IPronosticoFactory.java
│   │   ├── PronosticoFactory.java
│   │   ├── INotifierFactory.java
│   │   └── NotifierFactory.java
│   ├── Adapter/
│   │   ├── IDeporteAPI.java
│   │   ├── FutbolAPIAdapter.java
│   │   └── BaloncestoAPIAdapter.java
│   ├── State/
│   │   ├── IPronosticoState.java
│   │   ├── PronosticoPendienteState.java
│   │   ├── PronosticoAcertadoState.java
│   │   ├── PronosticoFallidoState.java
│   │   └── PronosticoEnRevisionState.java
│   ├── Chain of Responsibility/
│   │   ├── IIncidenciaHandler.java
│   │   ├── AbstractIncidenciaHandler.java
│   │   ├── MiembroSoporteHandler.java
│   │   ├── MiembroQCHandler.java
│   │   ├── AdministradorHandler.java
│   │   └── IncidenciaService.java
│   └── ...
└── Main.java                 # Clase principal con demostración de patrones
```

## Cómo Ejecutar

1. Compilar el proyecto:
   ```bash
   mvn compile
   ```

2. Ejecutar la simulación:
   ```bash
   mvn exec:java -Dexec.mainClass="com.sportspredictor.Main"
   ```

## Casos de Uso Demostrados

1. **Factory Method para Pronósticos**: Creación de diferentes tipos de pronósticos
2. **Factory Method para Notificaciones**: Envío por email, SMS y push
3. **Adapter Pattern**: Integración con APIs de fútbol y baloncesto
4. **State Pattern**: Manejo de estados de pronósticos con validaciones
5. **Chain of Responsibility**: Escalamiento automático de incidencias

## Ventajas de la Implementación

- **Mantenibilidad**: Código organizado y fácil de modificar
- **Extensibilidad**: Fácil agregar nuevos tipos, deportes y niveles de soporte
- **Testabilidad**: Cada patrón puede ser probado independientemente
- **Flexibilidad**: Cambios en APIs externas no afectan el código principal
- **Claridad**: Lógica de negocio bien separada y fácil de entender
