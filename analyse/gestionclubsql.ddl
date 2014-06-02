-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 9.1.6              
-- * Generator date: Feb 25 2013              
-- * Generation date: Sat May 31 06:59:29 2014 
-- * LUN file: C:\Users\Frederick\workspace\gestionclubbadminton\analyse\GestionBadminton.lun 
-- * Schema: GestionClubShemaMLD/SQL2 
-- ********************************************* 


-- Database Section
-- ________________ 


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table adresse (
     id_Adresse integer(11) not null,
     ville varchar(50) not null,
     rue varchar(50) not null,
     numero varchar(6) not null,
     boite varchar(4) not null,
     id_Pays integer(11) not null,
     constraint ID_adresse_ID primary key (id_Adresse));

create table adversaire (
     id_Personne integer(11) not null,
     id_Adversaire integer(11) not null,
     numero_Ligue varchar(9) not null,
     constraint ID_adver_perso_ID primary key (id_Personne));

create table classement (
     id_Classement integer(11) not null,
     discipline varchar(50) not null,
     categorie varchar(2) not null,
     constraint ID_classement_ID primary key (id_Classement));

create table club (
     id_Club integer(11) not null,
     nom_Club varchar(50) not null,
     constraint ID_club_ID primary key (id_Club));

create table comite (
     id_Comite integer(11) not null,
     id_Membre integer(11) not null,
     nom_Comite varchar(50) not null,
     date_Debut date not null,
     date_Fin date not null,
     constraint ID_comite_ID primary key (id_Comite),
     constraint SID_comit_membr_ID unique (id_Membre));

create table competiteur (
     id_Competiteur integer(11) not null,
     numero_Ligue varchar(9) not null,
     constraint ID_competiteur_ID primary key (id_Competiteur));

create table cotisation (
     id_Cotisation integer(11) not null,
     id_Operation integer(11) not null,
     id_TypeCotisation integer(11) not null,
     constraint ID_cotisation_ID primary key (id_Cotisation),
     constraint SID_cotis_opera_ID unique (id_Operation));

create table donne (
     id_Entraineur integer(11) not null,
     id_stage integer(11) not null,
     constraint ID_donne_ID primary key (id_stage, id_Entraineur));

create table entrainement (
     id_Entrainement integer(11) not null,
     jour varchar(8) not null,
     heure_Debut date not null,
     heure_Fin date not null,
     constraint ID_entrainement_ID primary key (id_Entrainement));

create table entraineur (
     id_Entraineur integer(11) not null,
     id_Personne integer(11) not null,
     diplome varchar(50) not null,
     constraint ID_entraineur_ID primary key (id_Entraineur),
     constraint SID_entra_perso_ID unique (id_Personne));

create table equipe (
     id_Equipe integer(11) not null,
     nom_Equipe varchar(50) not null,
     id_Rencontre integer(11) not null,
     id_Club integer(11) not null);

create table est_affilie (
     id_Competiteur integer(11) not null,
     saison date not null,
     id_Membre integer(11) not null,
     constraint ID_est_a_compe_ID primary key (id_Competiteur));

create table est_donne (
     id_Entrainement integer(11) not null,
     id_Salle integer(11)not null,
     constraint ID_est_donne_ID primary key (id_Salle, id_Entrainement));

create table joue (
     id_Competiteur integer(11) not null,
     id_Match integer(11) not null,
     constraint ID_joue_ID primary key (id_Match, id_Competiteur));

create table joue_un (
     id_Personne integer(11) not null,
     id_Match integer(11) not null,
     constraint ID_joue_un_ID primary key (id_Match, id_Personne));

create table matchs (
     id_Match integer(11) not null,
     type_Match varchar(50) not null,
     score varchar(15) not null,
     id_Rencontre integer(11) not null,
     constraint ID_matchs_ID primary key (id_Match));

create table membre (
     id_Membre integer(11) not null,
     id_Personne integer(11) not null,
     date_Naissance date not null,
     conjoint varchar(50) not null,
     courriel varchar(50) not null,
     telephone varchar(20) not null,
     id_Adresse integer(11) not null,
     constraint ID_membre_ID primary key (id_Membre),
     constraint SID_membr_perso_ID unique (id_Personne));

create table obtient (
     id_Classement integer(11) not null,
     id_Competiteur integer(11) not null,
     date date not null,
     constraint ID_obtient_ID primary key (id_Competiteur, id_Classement));

create table operation (
     id_Operation integer(11) not null,
     nom_Operation varchar(50) not null,
     description varchar(1024) not null,
     date date not null,
     montant char(1) not null,
     id_Type integer(11) not null,
     id_Entraineur integer(11),
     constraint ID_operation_ID primary key (id_Operation));

create table paye (
     id_Cotisation integer(11) not null,
     id_Membre integer(11) not null,
     saison date not null,
     constraint ID_paye_ID primary key (id_Cotisation, id_Membre));

create table pays (
     id_Pays integer(11) not null,
     nom_Pays varchar(50) not null,
     code_Pays varchar(5) not null,
     constraint ID_pays_ID primary key (id_Pays));

create table personne (
     id_Personne integer(11) not null,
     nom varchar(50) not null,
     prenom varchar(50) not null,
     sexe char not null,
     constraint ID_personne_ID primary key (id_Personne));

create table possede_un (
     id_Personne integer(11) not null,
     date date not null,
     id_Classement integer(11) not null,
     constraint ID_posse_adver_ID primary key (id_Personne));

create table rencontre (
     id_Rencontre integer(11) not null,
     type_Rencontre varchar(50) not null,
     date_Rencontre date not null,
     division varchar(50) not null,
     resultat varchar(50) not null,
     commentaires varchar(256) not null,
     id_Salle integer(11) not null,
     constraint ID_rencontre_ID primary key (id_Rencontre));

create table salle (
     id_Salle integer(11) not null,
     nom_Salle varchar(50) not null,
     nom_Responsable varchar(50) not null,
     id_Adresse integer(11) not null,
     constraint ID_salle_ID primary key (id_Salle));

create table stage (
     id_stage integer(11) not null,
     id_Operation integer(11) not null,
     nom_Stage varchar(50) not null,
     descriptif varchar(256) not null,
     date date not null,
     heure_Debut date not null,
     heure_Fin date not null,
     prix integer(11) not null,
     constraint ID_stage_ID primary key (id_stage),
     constraint SID_stage_opera_ID unique (id_Operation));

create table supervise (
     id_Entrainement integer(11) not null,
     id_Entraineur integer(11) not null,
     constraint ID_supervise_ID primary key (id_Entraineur, id_Entrainement));

create table typeCotisation (
     id_TypeCotisation integer(11) not null,
     nom_TypeCotisation varchar(50) not null,
     montant integer(11) not null,
     constraint ID_typeCotisation_ID primary key (id_TypeCotisation));

create table typeOperation (
     id_Type integer(11) not null,
     nom_Type varchar(50) not null,
     constraint ID_typeOperation_ID primary key (id_Type));


-- Constraints Section
-- ___________________ 

alter table adresse add constraint REF_adres_pays_FK
     foreign key (id_Pays)
     references pays (id_Pays);

alter table adversaire add constraint ID_adver_perso_CHK
     check(exists(select * from possede_un
                  where possede_un.id_Personne = id_Personne)); 

alter table adversaire add constraint ID_adver_perso_FK
     foreign key (id_Personne)
     references personne (id_Personne);

alter table classement add constraint ID_classement_CHK
     check(exists(select * from obtient
                  where obtient.id_Classement = id_Classement)); 

alter table comite add constraint SID_comit_membr_FK
     foreign key (id_Membre)
     references membre (id_Membre) ;

alter table competiteur add constraint ID_competiteur_CHK
     check(exists(select * from est_affilie
                  where est_affilie.id_Competiteur = id_Competiteur)); 

alter table competiteur add constraint ID_competiteur_CHK
     check(exists(select * from obtient
                  where obtient.id_Competiteur = id_Competiteur)); 

alter table cotisation add constraint REF_cotis_typeC_FK
     foreign key (id_TypeCotisation)
     references typeCotisation (id_TypeCotisation);

alter table cotisation add constraint SID_cotis_opera_FK
     foreign key (id_Operation)
     references operation (id_Operation);

alter table donne add constraint EQU_donne_stage
     foreign key (id_stage)
     references stage (id_stage);

alter table donne add constraint REF_donne_entra_FK
     foreign key (id_Entraineur)
     references entraineur (id_Entraineur);

alter table entrainement add constraint ID_entrainement_CHK
     check(exists(select * from est_donne
                  where est_donne.id_Entrainement = id_Entrainement)); 

alter table entraineur add constraint SID_entra_perso_FK
     foreign key (id_Personne)
     references personne (id_Personne);

alter table equipe add constraint REF_equip_renco_FK
     foreign key (id_Rencontre)
     references rencontre (id_Rencontre);

alter table equipe add constraint REF_equip_club_FK
     foreign key (id_Club)
     references club (id_Club);

alter table est_affilie add constraint REF_est_a_membr_FK
     foreign key (id_Membre)
     references membre (id_Membre);

alter table est_affilie add constraint ID_est_a_compe_FK
     foreign key (id_Competiteur)
     references competiteur (id_Competiteur);

alter table est_donne add constraint REF_est_d_salle
     foreign key (id_Salle)
     references salle (id_Salle);

alter table est_donne add constraint EQU_est_d_entra_FK
     foreign key (id_Entrainement)
     references entrainement (id_Entrainement);

alter table joue add constraint REF_joue_match
     foreign key (id_Match)
     references matchs (id_Match);

alter table joue add constraint REF_joue_compe_FK
     foreign key (id_Competiteur)
     references competiteur (id_Competiteur);

alter table joue_un add constraint REF_joue__match
     foreign key (id_Match)
     references matchs (id_Match);

alter table joue_un add constraint REF_joue__adver_FK
     foreign key (id_Personne)
     references adversaire (id_Personne);

alter table matchs add constraint REF_match_renco_FK
     foreign key (id_Rencontre)
     references rencontre (id_Rencontre);

alter table membre add constraint REF_membr_adres_FK
     foreign key (id_Adresse)
     references adresse (id_Adresse);

alter table membre add constraint SID_membr_perso_FK
     foreign key (id_Personne)
     references personne (id_Personne);

alter table obtient add constraint EQU_obtie_compe
     foreign key (id_Competiteur)
     references competiteur (id_Competiteur);

alter table obtient add constraint EQU_obtie_class_FK
     foreign key (id_Classement)
     references classement (id_Classement);

alter table operation add constraint REF_opera_typeO_FK
     foreign key (id_Type)
     references typeOperation (id_Type);

alter table operation add constraint REF_opera_entra_FK
     foreign key (id_Entraineur)
     references entraineur (id_Entraineur); 

alter table paye add constraint REF_paye_membr_FK
     foreign key (id_Membre)
     references membre (id_Membre);

alter table paye add constraint REF_paye_cotis
     foreign key (id_Cotisation)
     references cotisation (id_Cotisation);

alter table possede_un add constraint REF_posse_class_FK
     foreign key (id_Classement)
     references classement (id_Classement);

alter table possede_un add constraint ID_posse_adver_FK
     foreign key (id_Personne)
     references adversaire (id_Personne);

alter table rencontre add constraint REF_renco_salle_FK
     foreign key (id_Salle)
     references salle (id_Salle);

alter table salle add constraint REF_salle_adres_FK
     foreign key (id_Adresse)
     references adresse (id_Adresse);

alter table stage add constraint ID_stage_CHK
     check(exists(select * from donne
                  where donne.id_stage = id_stage)); 

alter table stage add constraint SID_stage_opera_FK
     foreign key (id_Operation)
     references operation (id_Operation);

alter table supervise add constraint REF_super_entra_1
     foreign key (id_Entraineur)
     references entraineur (id_Entraineur);

alter table supervise add constraint REF_super_entra_FK
     foreign key (id_Entrainement)
     references entrainement (id_Entrainement);


-- Index Section
-- _____________ 

create unique index ID_adresse_IND
     on adresse (id_Adresse);

create index REF_adres_pays_IND
     on adresse (id_Pays);

create unique index ID_adver_perso_IND
     on adversaire (id_Personne);

create unique index ID_classement_IND
     on classement (id_Classement);

create unique index ID_club_IND
     on club (id_Club);

create unique index ID_comite_IND
     on comite (id_Comite);

create unique index SID_comit_membr_IND
     on comite (id_Membre);

create unique index ID_competiteur_IND
     on competiteur (id_Competiteur);

create unique index ID_cotisation_IND
     on cotisation (id_Cotisation);

create index REF_cotis_typeC_IND
     on cotisation (id_TypeCotisation);

create unique index SID_cotis_opera_IND
     on cotisation (id_Operation);

create unique index ID_donne_IND
     on donne (id_stage, id_Entraineur);

create index REF_donne_entra_IND
     on donne (id_Entraineur);

create unique index ID_entrainement_IND
     on entrainement (id_Entrainement);

create unique index ID_entraineur_IND
     on entraineur (id_Entraineur);

create unique index SID_entra_perso_IND
     on entraineur (id_Personne);

create index REF_equip_renco_IND
     on equipe (id_Rencontre);

create index REF_equip_club_IND
     on equipe (id_Club);

create index REF_est_a_membr_IND
     on est_affilie (id_Membre);

create unique index ID_est_a_compe_IND
     on est_affilie (id_Competiteur);

create unique index ID_est_donne_IND
     on est_donne (id_Salle, id_Entrainement);

create index EQU_est_d_entra_IND
     on est_donne (id_Entrainement);

create unique index ID_joue_IND
     on joue (id_Match, id_Competiteur);

create index REF_joue_compe_IND
     on joue (id_Competiteur);

create unique index ID_joue_un_IND
     on joue_un (id_Match, id_Personne);

create index REF_joue__adver_IND
     on joue_un (id_Personne);

create unique index ID_matchs_IND
     on matchs (id_Match);

create index REF_match_renco_IND
     on matchs (id_Rencontre);

create unique index ID_membre_IND
     on membre (id_Membre);

create index REF_membr_adres_IND
     on membre (id_Adresse);

create unique index SID_membr_perso_IND
     on membre (id_Personne);

create unique index ID_obtient_IND
     on obtient (id_Competiteur, id_Classement);

create index EQU_obtie_class_IND
     on obtient (id_Classement);

create unique index ID_operation_IND
     on operation (id_Operation);

create index REF_opera_typeO_IND
     on operation (id_Type);

create index REF_opera_entra_IND
     on operation (id_Entraineur);

create unique index ID_paye_IND
     on paye (id_Cotisation, id_Membre);

create index REF_paye_membr_IND
     on paye (id_Membre);

create unique index ID_pays_IND
     on pays (id_Pays);

create unique index ID_personne_IND
     on personne (id_Personne);

create index REF_posse_class_IND
     on possede_un (id_Classement);

create unique index ID_posse_adver_IND
     on possede_un (id_Personne);

create unique index ID_rencontre_IND
     on rencontre (id_Rencontre);

create index REF_renco_salle_IND
     on rencontre (id_Salle);

create unique index ID_salle_IND
     on salle (id_Salle);

create index REF_salle_adres_IND
     on salle (id_Adresse);

create unique index ID_stage_IND
     on stage (id_stage);

create unique index SID_stage_opera_IND
     on stage (id_Operation);

create unique index ID_supervise_IND
     on supervise (id_Entraineur, id_Entrainement);

create index REF_super_entra_IND
     on supervise (id_Entrainement);

create unique index ID_typeCotisation_IND
     on typeCotisation (id_TypeCotisation);

create unique index ID_typeOperation_IND
     on typeOperation (id_Type);

