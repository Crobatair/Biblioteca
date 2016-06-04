SET check_function_bodies = false;
-- Author Model: Vasquez Madrid, Josue Alejandro

-- object: public.pais | type: TABLE --
CREATE TABLE public.pais(
	id_pais serial NOT NULL,
	nombre character varying(255) NOT NULL,
	CONSTRAINT pk_id_pais PRIMARY KEY (id_pais)

);
COMMENT ON TABLE public.pais IS 'Tabla que contiene los paises';
COMMENT ON COLUMN public.pais.id_pais IS 'codigo del pais';
COMMENT ON COLUMN public.pais.nombre IS 'nombre del pais';
COMMENT ON CONSTRAINT pk_id_pais ON public.pais IS 'llave primaria de pais';
ALTER TABLE public.pais OWNER TO postgres;

-- object: public.editorial | type: TABLE --
CREATE TABLE public.editorial(
	id_editorial serial NOT NULL,
	editorial character varying(255) NOT NULL,
	descripcion text,
	CONSTRAINT pk_id_editorial PRIMARY KEY (id_editorial)

);
COMMENT ON TABLE public.editorial IS 'Tabla con las editoriales';
COMMENT ON COLUMN public.editorial.id_editorial IS 'llave principal';
COMMENT ON COLUMN public.editorial.editorial IS 'Nombre de la editoria';
COMMENT ON COLUMN public.editorial.descripcion IS 'descripcion de la categoria';
COMMENT ON CONSTRAINT pk_id_editorial ON public.editorial IS 'constraint de editorial';
ALTER TABLE public.editorial OWNER TO postgres;

-- object: public.categoria | type: TABLE --
CREATE TABLE public.categoria(
	id_categoria serial NOT NULL,
	categoria character varying(255) NOT NULL,
	descripcion character varying(255),
	CONSTRAINT pk_id_categoria PRIMARY KEY (id_categoria)

);
COMMENT ON TABLE public.categoria IS 'Tabla con las categorias disponibles de los libros';COMMENT ON COLUMN public.categoria.id_categoria IS 'identificador unico de la categoria';COMMENT ON COLUMN public.categoria.categoria IS 'Nombre de la categoria';COMMENT ON COLUMN public.categoria.descripcion IS 'Descricion del la categoria';ALTER TABLE public.categoria OWNER TO postgres;

-- object: public.libro | type: TABLE --
CREATE TABLE public.libro(
	isbn character varying(20) NOT NULL,
	titulo character varying(255) NOT NULL,
	edicion character varying(25),
	autor text,
	id_pais integer,
	id_editorial integer,
	id_categoria integer NOT NULL,
	precio double precision,
	CONSTRAINT pk_isbn_libro PRIMARY KEY (isbn)

);
COMMENT ON TABLE public.libro IS 'Tabla con los lirbos que posee la biblioteca';COMMENT ON COLUMN public.libro.titulo IS 'Titulo del libro';COMMENT ON COLUMN public.libro.edicion IS 'Edicion del libro';COMMENT ON COLUMN public.libro.autor IS 'Autores/Autores del libro';COMMENT ON COLUMN public.libro.id_pais IS 'Pais';COMMENT ON COLUMN public.libro.id_editorial IS 'editorial';COMMENT ON COLUMN public.libro.id_categoria IS 'Categoria del libro';

-- object: public.ejemplar | type: TABLE --
CREATE TABLE public.ejemplar(
	isbn character varying(17) NOT NULL,
	numero_ejemplar integer NOT NULL,
	cod_barra character varying(255) NOT NULL,
	id_estado_ejemplar integer NOT NULL,
	CONSTRAINT pk_ejemplar PRIMARY KEY (isbn,numero_ejemplar)

);
COMMENT ON TABLE public.ejemplar IS 'Tabla que contiene todos los libros de la biblioteca';COMMENT ON COLUMN public.ejemplar.isbn IS 'llave principal del libro';COMMENT ON COLUMN public.ejemplar.numero_ejemplar IS 'Numero del ejemplar del libro ';COMMENT ON COLUMN public.ejemplar.cod_barra IS 'Codigo de barra del ejemplar';COMMENT ON CONSTRAINT pk_ejemplar ON public.ejemplar IS 'Relacion de la llave primaria de ejmeplar que esta formada por isbn y numero_ejemplar';

-- object: public.estado_ejemplar | type: TABLE --
CREATE TABLE public.estado_ejemplar(
	id_estado_ejemplar serial NOT NULL,
	estado character varying(255) NOT NULL,
	descripcion text,
	CONSTRAINT pk_id_estado_ejemplar PRIMARY KEY (id_estado_ejemplar)

);
COMMENT ON TABLE public.estado_ejemplar IS 'Tabla que contiene los posibles estados en que se encuentra el libro';COMMENT ON COLUMN public.estado_ejemplar.id_estado_ejemplar IS 'identificador unico del estado';COMMENT ON COLUMN public.estado_ejemplar.estado IS 'Nombre del estado';COMMENT ON COLUMN public.estado_ejemplar.descripcion IS 'Descripcion del estado ';COMMENT ON CONSTRAINT pk_id_estado_ejemplar ON public.estado_ejemplar IS 'relacion de la llave primaria de estado ejemplar por el campo de id_estado_ejmeplar';

-- object: public.usuario_sistema | type: TABLE --
CREATE TABLE public.usuario_sistema(
	usuario_sistema character varying(16) NOT NULL,
	password text NOT NULL,
	nombres character varying(255) NOT NULL,
	apellidos character varying(255) NOT NULL,
	direccion text,
	numero_contacto character varying(9),
	email text,
	acceso_total boolean NOT NULL DEFAULT false,
	CONSTRAINT pk_usuario_sistema PRIMARY KEY (usuario_sistema)

);
COMMENT ON TABLE public.usuario_sistema IS 'Tabla que contiene todos los usuarios de sistema';COMMENT ON COLUMN public.usuario_sistema.usuario_sistema IS 'Identificador unico de usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.password IS 'Contraña del usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.nombres IS 'Nombre del usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.apellidos IS 'Apellidos del usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.direccion IS 'Direccion del usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.numero_contacto IS 'Numero de contacto';COMMENT ON COLUMN public.usuario_sistema.email IS 'Correo electronico del usuario de sistema';COMMENT ON COLUMN public.usuario_sistema.acceso_total IS 'TRUE, tiene acceso total a el sistema, FALSE, acceso restringido en el sistema';

-- object: public.prestamo | type: TABLE --
CREATE TABLE public.prestamo(
	id_prestamo serial NOT NULL,
	usuario_sistema character varying(16) NOT NULL,
	usuario character varying(16) NOT NULL,
	timestamp_registro_prestamo timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	observaciones text,
	CONSTRAINT pk_id_prestamo PRIMARY KEY (id_prestamo)

);
COMMENT ON TABLE public.prestamo IS 'Tabla donde estan todos los prestamos';COMMENT ON COLUMN public.prestamo.id_prestamo IS 'Identificador unico del prestamo';COMMENT ON COLUMN public.prestamo.usuario_sistema IS 'Usuario de sistema que realiza el prestamo';COMMENT ON COLUMN public.prestamo.usuario IS 'Identificador del usuario que se lleva los libros';COMMENT ON COLUMN public.prestamo.timestamp_registro_prestamo IS 'Fecha y hora en que se realiza el prestamo';COMMENT ON COLUMN public.prestamo.observaciones IS 'Obseraviones sobre el prestamo';COMMENT ON CONSTRAINT pk_id_prestamo ON public.prestamo IS 'llave primaria de prestamo';

-- object: public.usuario | type: TABLE --
CREATE TABLE public.usuario(
	usuario character varying(16) NOT NULL,
	id_tipo_usuario integer NOT NULL,
	nombre character varying(255) NOT NULL,
	apellidos character varying(50) NOT NULL,
	direccion text,
	numero_contacto character varying(9),
	email text,
	dui character varying(10),
	nie integer,
	CONSTRAINT pk_usuario PRIMARY KEY (usuario)

);
COMMENT ON TABLE public.usuario IS 'Tabla que contiene los usuarios a los que se puede prestar';COMMENT ON COLUMN public.usuario.usuario IS 'Identificador unico del usuario';COMMENT ON COLUMN public.usuario.nombre IS 'Nombre del usuario';COMMENT ON COLUMN public.usuario.apellidos IS 'Apellidos del usuario';COMMENT ON COLUMN public.usuario.direccion IS 'Direccion de contacto del usuario';

-- object: public.tipo_usuario | type: TABLE --
CREATE TABLE public.tipo_usuario(
	id_tipo_usuario serial NOT NULL,
	nombre character varying(255) NOT NULL,
	descripcion smallint,
	CONSTRAINT pk_id_tipo_usuario PRIMARY KEY (id_tipo_usuario)

);
COMMENT ON TABLE public.tipo_usuario IS 'Tipo del usuario';COMMENT ON COLUMN public.tipo_usuario.id_tipo_usuario IS 'Id del tipo de usuario';COMMENT ON COLUMN public.tipo_usuario.nombre IS 'Nombre del tipo de usuario';

-- object: public.detalle_prestamo | type: TABLE --
CREATE TABLE public.detalle_prestamo(
	isbn character varying(20) NOT NULL,
	id_ejemplar integer NOT NULL,
	id_prestamo integer NOT NULL,
	usuario_sistema character varying(16) NOT NULL,
	timestamp_devuelto timestamp,
	observacion text,
	CONSTRAINT pk_detalle_prestamo PRIMARY KEY (isbn,id_ejemplar,id_prestamo)

);
COMMENT ON TABLE public.detalle_prestamo IS 'Tabla que contiene cada detalle del prestamo';COMMENT ON COLUMN public.detalle_prestamo.isbn IS 'isbn';COMMENT ON COLUMN public.detalle_prestamo.id_ejemplar IS 'id del ejemplar';COMMENT ON COLUMN public.detalle_prestamo.id_prestamo IS 'id del prestamo';COMMENT ON COLUMN public.detalle_prestamo.timestamp_devuelto IS 'Fecha y hora en que fue devuelto el el ejemplar del libro';COMMENT ON COLUMN public.detalle_prestamo.observacion IS 'Observaciones de como se entrego el ejemplar';

-- object: fk_id_pais_pais_libro | type: CONSTRAINT --
ALTER TABLE public.libro ADD CONSTRAINT fk_id_pais_pais_libro FOREIGN KEY (id_pais)
REFERENCES public.pais (id_pais) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_id_editorial | type: CONSTRAINT --
ALTER TABLE public.libro ADD CONSTRAINT fk_id_editorial FOREIGN KEY (id_editorial)
REFERENCES public.editorial (id_editorial) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_id_categoria_categoria_libro | type: CONSTRAINT --
ALTER TABLE public.libro ADD CONSTRAINT fk_id_categoria_categoria_libro FOREIGN KEY (id_categoria)
REFERENCES public.categoria (id_categoria) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_isbn_libro_ejemplar | type: CONSTRAINT --
ALTER TABLE public.ejemplar ADD CONSTRAINT fk_isbn_libro_ejemplar FOREIGN KEY (isbn)
REFERENCES public.libro (isbn) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_id_estado_ejemplar_estado_ejemplar_ejemplar | type: CONSTRAINT --
ALTER TABLE public.ejemplar ADD CONSTRAINT fk_id_estado_ejemplar_estado_ejemplar_ejemplar FOREIGN KEY (id_estado_ejemplar)
REFERENCES public.estado_ejemplar (id_estado_ejemplar) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_usuario_sistema_usuario_sistema_prestamo | type: CONSTRAINT --
ALTER TABLE public.prestamo ADD CONSTRAINT fk_usuario_sistema_usuario_sistema_prestamo FOREIGN KEY (usuario_sistema)
REFERENCES public.usuario_sistema (usuario_sistema) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_usuario_usuario_prestamo | type: CONSTRAINT --
ALTER TABLE public.prestamo ADD CONSTRAINT fk_usuario_usuario_prestamo FOREIGN KEY (usuario)
REFERENCES public.usuario (usuario) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_id_tipo_usuario_tipo_usuario_usuario | type: CONSTRAINT --
ALTER TABLE public.usuario ADD CONSTRAINT fk_id_tipo_usuario_tipo_usuario_usuario FOREIGN KEY (id_tipo_usuario)
REFERENCES public.tipo_usuario (id_tipo_usuario) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_ejemplar_ejemplar_detalle_prestamo | type: CONSTRAINT --
ALTER TABLE public.detalle_prestamo ADD CONSTRAINT fk_ejemplar_ejemplar_detalle_prestamo FOREIGN KEY (isbn,id_ejemplar)
REFERENCES public.ejemplar (isbn,numero_ejemplar) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_id_prestamo_prestamo_detalle_prestamo | type: CONSTRAINT --
ALTER TABLE public.detalle_prestamo ADD CONSTRAINT fk_id_prestamo_prestamo_detalle_prestamo FOREIGN KEY (id_prestamo)
REFERENCES public.prestamo (id_prestamo) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;


-- object: fk_usuario_sistema_usuario_sistema_detalle_prestamo | type: CONSTRAINT --
ALTER TABLE public.detalle_prestamo ADD CONSTRAINT fk_usuario_sistema_usuario_sistema_detalle_prestamo FOREIGN KEY (usuario_sistema)
REFERENCES public.usuario_sistema (usuario_sistema) MATCH SIMPLE
ON DELETE RESTRICT ON UPDATE CASCADE NOT DEFERRABLE;



