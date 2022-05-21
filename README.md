<table>
 <tr>
    <td width="100px"><img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
  <td width="1000px"> <h2> Spring + JPA + H2 + Maven Ejercicio 3 Unidad 25 </h2> </td>
  
 </tr>
</table>

[![Java](https://img.shields.io/badge/Java-FrontEnd-informational)]()
[![JBuilder](https://img.shields.io/badge/JBuilder-View-critical)]()
[![JUnit 5](https://img.shields.io/badge/JUnit%205-Testing-success)]()
[![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey)]()
[![SQL](https://img.shields.io/badge/SQL-DataBase-yellowgreen)]()
[![Spring](https://img.shields.io/badge/Spring-infrastructure-brightgreen)]()
[![Maven](https://img.shields.io/badge/Maven-ProjectStructure-blueviolet)]()

Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- Ixabel Justo Etxeberria](https://github.com/Kay-Nicte)<br>
  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)

<p align="justify">Se crea un proyecto Maven utilizando la tecnología spring, se definen como componentes los spring services, la base de datos H2 y JPA. Se crea la estructura de proyecto en capas definiendo los paquetes de controllers, dao, dto y services. Para proseguir se crean las entidades 'almacenes' y 'cajas' con una relación de uno a muchos (one to many). Se definen las columnas y mediante anotaciones se mapea con los atributos de la entidad.</p>

<p align="justify">Antes de proceder con la creación de paquetes y estructuras se definirán los parámetros de acceso a la base de datos H2, para ello se añaden las siguiente línas en el fichero 'application.propierties' ubicado en 'src/main/resources/.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169618188-c5a4c9ad-c431-4d2b-a693-a025b1e85654.png">
</p>

A continuación se procederá a revisar las dependencias del fichero 'pom.xml' ubicado en la raíz de la carpeta del proyecto de Spring. Se deberá verificar que aparezcan las siguiente propiedades:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.crud.spring</groupId>
	<artifactId>UD25-Ejercicio_3</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>UD25-Ejercicio_3</name>
	<description>Ejercicio UD25</description>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```

<p align="justify">Una vez estén revisados el pom y el fichero de propiedades de la base de datos H2 se procederá a la creación de las entidades. El programa tendrá tantas entidades como tablas existan en el modelo relacional. En la siguiente entidad se define la anotación many to one que hará referencia a la relación many to one.</p>

```java
 package com.crud.springmaven.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Almacenes")

public class Almacenes {

	@Id
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "lugar")
	private String lugar;

	@Column(name = "capacidad")
	private int capacidad;

	@OneToMany
	@JoinColumn(name = "codigo")

	private List<Cajas> cajas;

	public Almacenes() {
	}

	public Almacenes(Long codigo, String lugar, int capacidad) {
		this.codigo = codigo;
		this.lugar = lugar;
		this.capacidad = capacidad;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setCajas(List<Cajas> cajas) {
		this.cajas = cajas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Cajas")
	public List<Cajas> getCaja() {
		return cajas;
	}

}
```
 
En la siguiente entidad se define la anotación one to many.
 
 ```java
package com.crud.springmaven.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cajas")

public class Cajas {

	@Id
	@Column(name = "num_referencia")
	private String num_referencia;

	@Column(name = "contenido")
	private String contenido;
	@Column(name = "valor")
	private int valor;

	@ManyToOne
	@JoinColumn(name = "id_almacen")

	private Almacenes almacenes;

	public Cajas() {
	}

	public Cajas(String num_referencia, String contenido, int valor, Almacenes almacenes) {
		super();
		this.num_referencia = num_referencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacenes = almacenes;
	}

	public String getNumReferencia() {
		return num_referencia;
	}

	public void setNumReferencia(String num_referencia) {
		this.num_referencia = num_referencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacenes getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(Almacenes almacenes) {
		this.almacenes = almacenes;
	}

}
 ```
 
<p align="justify"> Una vez estén definidas ambas entidades se procederá a la creación y definición de los métodos en las interfaces de la capa service. Para ello se creará en el paquete services la interfaz 'AlmacenesService' y 'CajasService'.</p>
 
 ```java
 package com.crud.springmaven.Services;

import java.util.List;

import com.crud.springmaven.DTO.Almacenes;

public interface AlmacenesService {

	public List<Almacenes> listarAlmacenes();

	public Almacenes crearAlmacen(Almacenes almacen);

	public Almacenes buscarAlmacenCodigo(Long codigo);

	public void eliminarAlmacen(Long codigo);

	public Almacenes modificarAlmacen(Almacenes almacen);

}
 ```
 
 Se muestra el código de la interfaz 'CajasService':
 
 
 ```java
 package com.crud.springmaven.Services;

import java.util.List;

import com.crud.springmaven.DTO.Cajas;

public interface CajasService {

	public List<Cajas> listarCajas();

	public Cajas crearCajas(Cajas cajas);

	public Cajas buscarCajasCodigo(String NumReferencia);

	public void eliminarCajas(String NumReferencia);

	public Cajas modificarCajas(Cajas cajas);

}
 ```
 
<p align="justify">Una vez estén listas las cabeceras de las funciones de la interfaz se procederá a crear el DAO. Para ello se crearán las interfaces 'AlmacenesDAO' y 'CajasDAO'. Ambas interfaces heredarán los métodos del JpaRepository enviando como parámetro en identificador de cada entidad con el tipo. </p>
  
<p align="justify">Esta herencia es utilizada para obtener los métodos propios de JPA en relación con la base de datos.</p>
  
 Se muestra el código de la interfaz 'AlmacenesDAO':
  
 ```java
package com.crud.springmaven.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springmaven.DTO.Almacenes;

@Repository
public interface AlmacenesDAO extends JpaRepository<Almacenes, Long> {

} 
 ```
 
Se muestra el código de la interfaz 'CajasDAO': 
 
 ```java
 package com.crud.springmaven.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.springmaven.DTO.Cajas;

@Repository
public interface CajasDAO extends JpaRepository<Cajas, String> {

}
 ```
 

 
<p align="justify">El siguiente paso será crear en el paquete service las clases que implementarán tanto la interface de la capa service como la interface de la capa DAO, de esta forma dicha clase tendrá que utilizar de forma obligatoria todas y cada una de las funciones definidas en ambas interfaces.</p>

<p align="justify">Es muy importante que a lo largo de este proceso se inserten las anotaciones correspondiente, la falta de una de ellas puede afectar al flujo del programa.</p>
    
Se muestra el código de la clase 'AlmacenesServiceImpl':
 
 ```java
package com.crud.springmaven.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springmaven.DAO.AlmacenesDAO;
import com.crud.springmaven.DTO.Almacenes;

@Service
public class AlmacenesServiceImpl implements AlmacenesService {

//Es para decirle a Spring que aplique la autoinyección de dependencias (para traer los métodos del DAO)

	@Autowired
	AlmacenesDAO almacenesDAO;

	@Override
	public List<Almacenes> listarAlmacenes() {
		return almacenesDAO.findAll();
	}

	@Override
	public Almacenes crearAlmacen(Almacenes almacen) {
		return almacenesDAO.save(almacen);
	}

	@Override
	public Almacenes buscarAlmacenCodigo(Long codigo) {
		return almacenesDAO.findById(codigo).get();
	}

	@Override
	public void eliminarAlmacen(Long codigo) {
		almacenesDAO.deleteById(codigo);
	}

	@Override
	public Almacenes modificarAlmacen(Almacenes almacen) {
		return almacenesDAO.save(almacen);
	}

}
 
 ```
 
Se muestra el código de la clase 'CajasServiceImpl':
 
 ```java
 package com.crud.springmaven.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.springmaven.DAO.CajasDAO;
import com.crud.springmaven.DTO.Cajas;

@Service
public class CajasServiceImpl implements CajasService {

	@Autowired
	CajasDAO cajasDAO;

	@Override
	public List<Cajas> listarCajas() {
		return cajasDAO.findAll();
	}

	@Override
	public Cajas crearCajas(Cajas cajas) {
		return cajasDAO.save(cajas);
	}

	@Override
	public Cajas buscarCajasCodigo(String NumReferencia) {
		return cajasDAO.findById(NumReferencia).get();
	}

	@Override
	public void eliminarCajas(String NumReferencia) {
		cajasDAO.deleteById(NumReferencia);
	}

	@Override
	public Cajas modificarCajas(Cajas cajas) {
		return cajasDAO.save(cajas);
	}

}
 ```
    
<p align="justify">Por último se crearán los controladores. En estas clases irá albergada la información relativa al mapeo de los end-points con las funcionalidades del java. Se definen las clases como @RestController y se parametriza con el @RequestMapping("/api"). Como se ha mencionado anteriomente, es muy importante el uso de anotaciones para el funcionamiento correcto del aplicativo con sus endpoints, por eso es muy recomendable prestar atención a cada línea de código que forma el programa.</p>
  
<p align="justify">También en los controladores se desarrolla el código de las funcionalidades que se reciben de la clase service.</p>
  
Se muestra el código del controlador 'AlmacenesController':
 
  ```java
package com.crud.springmaven.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.springmaven.DTO.Almacenes;
import com.crud.springmaven.Services.AlmacenesServiceImpl;

/**
 * Clase @AlmacenesController. Mappea las funcionalidades con las rutas de la
 * api.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */

@RestController
@RequestMapping("/api")

public class AlmacenesController {

	/** Se crea una instancia del tipo @AlmacenesServiceImpl */
	@Autowired
	AlmacenesServiceImpl almacenesServiceImpl;

	/** Método para listar almacenes */
	@GetMapping("/almacenes")
	public List<Almacenes> listarAlmacenes() {
		return almacenesServiceImpl.listarAlmacenes();
	}

	/** Método para listar almacenes por código */
	@GetMapping("/almacenes/{codigo}")
	public Almacenes listarAlmacenCodigo(@PathVariable(name = "codigo") Long codigo) {
		return almacenesServiceImpl.buscarAlmacenCodigo(codigo);
	}

	/** Método para crear un nuevo almacén */
	@PostMapping("/almacenes")
	public Almacenes crearAlmacen(@RequestBody Almacenes almacenes) {
		return almacenesServiceImpl.crearAlmacen(almacenes);
	}

	/** Método para actualizar un almacén */
	@PutMapping("/almacenes/{codigo}")
	public Almacenes actualizarAlmacen(@PathVariable(name = "codigo") Long codigo, @RequestBody Almacenes almacenes) {
		/** Se definen instancias del tipo Almacenes */
		Almacenes almacen_a_actualizar = new Almacenes();
		Almacenes actualizado = new Almacenes();
		/** Se filtra el almacén a actualizar por código */
		almacen_a_actualizar = almacenesServiceImpl.buscarAlmacenCodigo(codigo);
		/** Se actualizan los valores */
		almacen_a_actualizar.setCodigo(almacenes.getCodigo());
		almacen_a_actualizar.setLugar(almacenes.getLugar());
		almacen_a_actualizar.setCapacidad(almacenes.getCapacidad());

		actualizado = almacenesServiceImpl.modificarAlmacen(almacen_a_actualizar);

		return actualizado;
	}

	/** Método para eliminar un almacén */
	@DeleteMapping("/almacenes/{codigo}")
	public void eliminarAlmacen(@PathVariable(name = "codigo") Long codigo) {
		almacenesServiceImpl.eliminarAlmacen(codigo);
		System.out.println("Almacén eliminado con exito.");
	}
}
 ```
 
Se muestra el código del controlador 'CajasController':

```java
package com.crud.springmaven.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.springmaven.DTO.Cajas;
import com.crud.springmaven.Services.CajasServiceImpl;

/**
 * Clase @CajasController. Mappea las funcionalidades con las rutas de la api.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */

@RestController
@RequestMapping("/api")

public class CajasController {

	/** Se crea una instancia del tipo @CajasServiceImpl */
	@Autowired
	CajasServiceImpl cajasServiceImpl;

	/** Método para listar cajas */
	@GetMapping("/cajas")
	public List<Cajas> listarCajas() {
		return cajasServiceImpl.listarCajas();
	}

	/** Método para crear una nueva caja */
	@PostMapping("/cajas")
	public Cajas guardarCaja(@RequestBody Cajas cajas) {
		return cajasServiceImpl.crearCajas(cajas);
	}

	/** Método para buscar una caja por codigo */
	@GetMapping("/cajas/{num_referencia}")
	public Cajas buscarCajasId(@PathVariable(name = "num_referencia") String num_referencia) {
		return cajasServiceImpl.buscarCajasCodigo(num_referencia);

	}

	/** Método para eliminar una caja */
	@PutMapping("/cajas/{num_referencia}")
	public Cajas actualizarCaja(@PathVariable(name = "num_referencia") String num_referencia,
			@RequestBody Cajas cajas) {
		/** Se definen instancias del tipo Cajas */
		Cajas caja_a_actualizar = new Cajas();
		Cajas actualizado = new Cajas();
		/** Se filtra la caja a actualizar por código */
		caja_a_actualizar = cajasServiceImpl.buscarCajasCodigo(num_referencia);
		/** Se actualizan los valores */
		caja_a_actualizar.setNumReferencia(cajas.getNumReferencia());
		caja_a_actualizar.setContenido(cajas.getContenido());
		caja_a_actualizar.setValor(cajas.getValor());
		caja_a_actualizar.setAlmacenes(cajas.getAlmacenes());

		actualizado = cajasServiceImpl.modificarCajas(caja_a_actualizar);

		return actualizado;
	}

	/** Método para eliminar una caja */
	@DeleteMapping("/cajas/{num_referencia}")
	public void eliminarCaja(@PathVariable(name = "num_referencia") String num_referencia) {
		cajasServiceImpl.eliminarCajas(num_referencia);
		System.out.println("Caja eliminada con exito.");
	}
}
```

<p align="justify">Cuando esté finalizada la aplicación se comprobará el correcto funcionamiento de este utilizando la herramienta postman. Esta herramienta se utiliza para verificar los endpoints del aplicativo lanzando peticiones HTTP. La primera validación a realizar será listar todos los almacenes y cajas.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649329-748a7ae9-f5c0-4586-be18-6820a994639b.PNG">
</p>

<p align="justify">La imagen anterior muestra el resultado de listar todos los almacenes, para ello se utiliza el método GET y se apunta al endpoint /api/almacenes. En la siguiente imagen se utiliza la misma funcionalidad GET pero apuntando a /api/cajas, con este método devolverá todas las cajas existentes en la base de datos H2.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649406-e5c17456-5b63-4883-ab55-123f4ae9f55e.PNG">
</p>

<p align="justify">A continuación se verificará la devolución de cajas y almacen mediante su identificador, para ello se utilizará el método GET apuntando a /api/almacenes/{id} substituyendo la id por el código identificativo de almacen.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649494-981877eb-b281-4a3c-a0cd-d91a7dd210cf.PNG">
</p>

<p align="justify">Se realiza el mismo procedimiento en cajas, se apunta mediante GET al identificativo de las cajas /api/cajas/{id} substituyendo el ID por el identificador propio de cajas.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649543-0091eae3-17f9-42fd-a664-44db11be9922.PNG">
</p>

<p align="justify">Para continuar se verificará la eliminación de un almacén o caja, para ello se utiliza el método HTTP DELETE. Al no introducir ningún tipo de sentencia que muestre el resultado no será visible, para ello se muestra la eliminación de un elemento y el resultado listando todos.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649636-b07ffa67-4617-4054-84bf-ae359eaffc93.PNG">
</p>

A continuación se muestra el resultado de la eliminación.

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649670-c4d84f69-e125-440e-b706-6be247573b71.PNG">
</p>

<p align="justify">Se realizará el mismo procedimiento con las cajas, se apuntará a la dirección de la api referente a la eliminación de cajas y mediante el método DELETE se eliminará una caja introduciendo el ID en la ruta.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649719-8aacb3b6-4dc0-4adb-ad23-d9b4bee162f4.PNG">
</p>

Se verificará la eliminación de la caja.

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649746-f7d4e8df-be18-450f-903a-f31c174c2bff.PNG">
</p>

<p align="justify">Una vez comprobado el funcionamiento de visualizar todas las cajas, almacenes, de visualizar cajas y almacenes por ID y de eliminar las cajas y almacenes mediante ID se procederá a verificar el funcionamiento de la creación de Cajas o Almacenes, para ello se utilizará el método HTTP POST acompañado de la URI de los endpoints. En la siguiente imagen se podrá observar de forma visual.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649837-13b610ca-3a21-4042-a74c-cc1df61be87f.PNG">
</p>

Se realiza el mismo procedimiento con las cajas:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169649906-a24a026a-833f-485c-9ff1-d39c616faad1.PNG">
</p>

<p align="justify">Por último faltaría verificar la modificación de almacenes y cajas existentes, para ello se utiliza la sentencia PUT de HTTP acompañado de la URI del endpoint de modificar caja o almacén. En la siguiente imagen se muestra como modificar un almacén.</p>

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169650006-a3f59ec5-3e44-4101-b6a5-6ead4f007d09.PNG">
</p>

Se realiza el mismo proceso con cajas:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169650057-6ce955db-5803-4075-b48f-287d5ed012f3.PNG">
</p>

<p align="justify">Y con esto ya se habrían comprobado todos los endpoints mediante postman, muy importante a la hora de realizar un proyecto con Spring y H2 estructurar bien el código y verificar el uso correcto de las anotaciones.</p>
