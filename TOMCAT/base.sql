CREATE  TABLE "public"."admin" ( 
    login                varchar(256)  NOT NULL ,
    mdp                  varchar(256)  NOT NULL 
 );

CREATE  TABLE "public".avance ( 
    idavance             integer  NOT NULL ,
    idemployee           integer  NOT NULL ,
    dateavance           date  NOT NULL ,
    montant              integer  NOT NULL ,
    CONSTRAINT pk_avance_idavance PRIMARY KEY ( idavance )
 );

CREATE  TABLE "public".categorieconge ( 
    idcategorieconge     integer  NOT NULL ,
    CONSTRAINT pk_categorieconge_idcategorieconge PRIMARY KEY ( idcategorieconge )
 );

CREATE  TABLE "public".conge ( 
    idconge              integer  NOT NULL ,
    typeconge            varchar(50)  NOT NULL ,
    CONSTRAINT pk_conge_idconge PRIMARY KEY ( idconge )
 );

CREATE  TABLE "public".contrat ( 
    idcontrat            integer  NOT NULL ,
    typecontrat          varchar(256)  NOT NULL ,
    duree                varchar(256)  NOT NULL ,
    CONSTRAINT pk_contrat_idcontrat PRIMARY KEY ( idcontrat )
 );

CREATE  TABLE "public".poste ( 
    idposte              integer  NOT NULL ,
    nomposte             varchar(256)  NOT NULL ,
    CONSTRAINT pk_poste_poste PRIMARY KEY ( idposte )
 );

CREATE  TABLE "public".employee ( 
    idemployee           integer  NOT NULL ,
    idposte              integer  NOT NULL ,
    idcontrat            integer  NOT NULL ,
    nom                  varchar(50)  NOT NULL ,
    datenaissance        date  NOT NULL ,
    sexe                 varchar(10)  NOT NULL ,
    dateembauche         date  NOT NULL ,
    adresse              varchar(100)  NOT NULL ,
    mdp                  varchar(50)   ,
    photo                varchar(256)  NOT NULL ,
    CONSTRAINT pk_employee_idemployee PRIMARY KEY ( idemployee )
 );

CREATE  TABLE "public".paie ( 
    idpaie               integer  NOT NULL ,
    idemployee           integer  NOT NULL ,
    "date"               date  NOT NULL ,
    heuresupplementaire  integer   ,
    indemnite            integer   ,
    CONSTRAINT pk_paie_idpaie PRIMARY KEY ( idpaie )
 );

CREATE  TABLE "public".demandeconge ( 
    iddemande            integer  NOT NULL ,
    idemployee           integer  NOT NULL ,
    idconge              integer  NOT NULL ,
    duree                integer  NOT NULL ,
    estvalider           integer   ,
    CONSTRAINT pk_demandeconge_iddemande PRIMARY KEY ( iddemande )
 );

ALTER TABLE "public".demandeconge ADD CONSTRAINT fk_demandeconge_conge FOREIGN KEY ( idconge ) REFERENCES "public".conge( idconge ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "public".demandeconge ADD CONSTRAINT fk_demandeconge_employee FOREIGN KEY ( idemployee ) REFERENCES "public".employee( idemployee ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "public".employee ADD CONSTRAINT fk_employee_contrat FOREIGN KEY ( idcontrat ) REFERENCES "public".contrat( idcontrat );

ALTER TABLE "public".employee ADD CONSTRAINT fk_employee_poste FOREIGN KEY ( idposte ) REFERENCES "public".poste( idposte ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "public".paie ADD CONSTRAINT fk_paie_employee FOREIGN KEY ( idemployee ) REFERENCES "public".employee( idemployee ) ON DELETE CASCADE ON UPDATE CASCADE;
