USE campus_covid_system; --use database


CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL,
    nam VARCHAR(50) NOT NULL,
    car VARCHAR(20) NOT NULL,
    acc VARCHAR(50) NOT NULL,
    pwd VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_acc (acc),
    UNIQUE KEY uk_pwd(pwd)
);
--create table users


CREATE TABLE IF NOT EXISTS dep (
    depno BIGINT NOT NULL,
    depnam VARCHAR(50) NOT NULL,
    dacc VARCHAR(50) NOT NULL,
    dpwd VARCHAR(50) NOT NULL,
    PRIMARY KEY (depno),
    UNIQUE KEY uk_depnam (depnam) ,
    UNIQUE KEY uk_dacc (dacc),
    UNIQUE KEY uk_dpwd(dpwd)
);
-- create department table

CREATE TABLE IF NOT EXISTS apa (
    apano VARCHAR(50) NOT NULL,
    park VARCHAR(50) NOT NULL,
    PRIMARY KEY (apano)
);--create apartment table

CREATE TABLE IF NOT EXISTS cou (
    cno BIGINT NOT NULL,
    course VARCHAR(50) NOT NULL,
    PRIMARY KEY (cno)
);--create course table

CREATE TABLE stu(
    id BIGINT NOT NULL,
    nam VARCHAR(50) NOT NULL,
    ins VARCHAR(50) NOT NULL,
    dept VARCHAR(50) NOT NULL,
    gra INT NOT NULL,
    apano VARCHAR(50) NOT NULL,
    isback CHAR(4) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_stu_apa FOREIGN KEY (apano) REFERENCES apa(apano) ON DELETE RESTRICT ON UPDATE CASCADE,
    constraint fk_stu_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE RESTRICT ON UPDATE CASCADE
);--create student table

create table tea(
    id BIGINT NOT NULL,
    nam VARCHAR(50) NOT NULL,
    ins VARCHAR(50) NOT NULL,
    tcno BIGINT NOT NULL,
    isback CHAR(4) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_tea_cou FOREIGN KEY (tcno) REFERENCES cou(cno) on DELETE RESTRICT on update CASCADE,
    constraint fk_tea_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE RESTRICT ON UPDATE CASCADE
);--create teacher table

CREATE TABLE depmag (
    depno BIGINT NOT NULL,
    id BIGINT NOT NULL,
    PRIMARY KEY (depno, id),
    CONSTRAINT fk_depmag_dep FOREIGN KEY (depno) REFERENCES dep (depno) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_depmag_stu FOREIGN KEY (id) REFERENCES stu (id) ON DELETE RESTRICT ON UPDATE CASCADE
);-- create department-manager-student table

create table tdepmag(
    depno BIGINT NOT NULL,
    id BIGINT NOT NULL,
    PRIMARY KEY (id,depno),
    constraint fk_tdepmag_dep FOREIGN KEY(depno) references dep(depno) on delete RESTRICT on update CASCADE,
    constraint fk_tdepmag_tea FOREIGN KEY(id) REFERENCES tea(id) on delete restrict on update CASCADE
);--create department manage teacher table

create table elecou(
    id BIGINT NOT NULL,
    cno BIGINT NOT NULL,
    PRIMARY KEY (id,cno),
    constraint fk_elecou_stu FOREIGN KEY(id) REFERENCES stu(id) on delete restrict on update CASCADE,
    constraint fk_elecou_cou FOREIGN KEY(cno) REFERENCES cou(cno) on delete restrict on update CASCADE
);--create elective course table

create table addr(
    teabuild VARCHAR(50) NOT NULL,
    classno VARCHAR(50) NOT NULL,
    PRIMARY KEY(classno)
);--create teaching building and class number table

create table class(
    cno BIGINT NOT NULL,
    id BIGINT NOT NULL,
    classno VARCHAR(50) NOT NULL,
    course VARCHAR(50) NOT NULL,
    classtim VARCHAR(100) NOT NULL,
    PRIMARY KEY(id,classno),
    constraint fk_class_id FOREIGN KEY(id) REFERENCES stu(id) on delete restrict on update CASCADE,
    constraint fk_class_addr FOREIGN KEY(classno) REFERENCES addr(classno) on delete restrict on update CASCADE
);--create class table

create table inoatt(
    id BIGINT NOT NULL,
    isatt varchar(4) NOT NULL,
    times SMALLINT NOT NULL,
    PRIMARY KEY(id),
    constraint fk_inoatt_stu Foreign Key(id) REFERENCES stu(id) on delete RESTRICT on update CASCADE
);--create vaccination status of students table

create table tinoatt(
    id BIGINT NOT NULL,
    isatt varchar(4) NOT NULL,
    times SMALLINT NOT NULL,
    PRIMARY KEY(id),
    constraint fk_tinoatt_tea FOREIGN KEY(id) REFERENCES tea(id) on delete restrict on update CASCADE
);--create vaccination status of teachers table

create table nat(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    ndepnam varchar(20) NOT NULL,
    res VARCHAR(20) NOT null,
    Time date NOT NULL,
    PRIMARY KEY(id)
);--create student nucleic acid test table
--constraint fk_nat_stu FOREIGN KEY(id) REFERENCES stu(id) on delete RESTRICT on update CASCADE
create table tnat(
    id BIGINT NOT NULL,
    res varchar(20) NOT NULL,
    dat date NOT NULL,
    remdat date NOT NULL,
    PRIMARY KEY(id),
    constraint fk_tnat_tea FOREIGN KEY(id) REFERENCES tea(id) on delete RESTRICT on update CASCADE
);--create teacher nucleic acid test table 

create table nbpat (
    id BIGINT NOT NULL,
    res VARCHAR(20) NOT NULL,
    sdat date NOT NULL,
    edat date NOT NULL,
    nam VARCHAR(50) NOT NULL,
    loc VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    constraint fk_nbpat_stu FOREIGN KEY (id) REFERENCES stu(id) on delete RESTRICT on update CASCADE
);--create not back to school patient table(students)

create table tnbpat(
    id BIGINT NOT null,
    res VARCHAR(20) NOT NULL,
    sdat date NOT NULL,
    edat date NOT NULL,
    nam varchar(50) NOT NULL,
    loc varchar(50) NOT NULL,
    PRIMARY KEY(id),
    constraint fk_tnbpat_tea FOREIGN KEY(id) REFERENCES tea(id) on delete RESTRICT on update CASCADE
);--create teacher not back to school patient table

create table pat(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    make_time date NOT NULL,
    state varchar(20) NOT NULL,
    PRIMARY KEY(id)
);--create patient table(students in school)
--constraint fk_pat_stu FOREIGN KEY(id) REFERENCES stu(id) on delete restrict on update CASCADE

create table tpat(
    id BIGINT NOT NULL,
    res varchar(20) NOT NULL,
    sdat date NOT NULL,
    edat date NOT NULL,
    nam varchar(50) NOT NULL,
    PRIMARY KEY(id),
    constraint fk_tpat_tea FOREIGN KEY(id) REFERENCES tea(id) on delete restrict on update CASCADE
);--create patient table(teachers in school)

create table clop(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT null,
    conadd varchar(20) NOT NULL,
    swdat date NOT NULL,
    ewdat date NOT null,
    PRIMARY KEY(id)
);--create close contact person table

create table clo(
    cloid BIGINT NOT NULL,
    patid BIGINT NOT NULL,
    con varchar(100) NOT null,
    conadd varchar(100) NOT NULL,
    contim varchar(100) NOT NULL,
    PRIMARY KEY(cloid,patid)
);--create close contact table 

create table dis(
    classno varchar(50) NOT NULL,
    patid BIGINT NOT NULL,
    isdis char(4) NOT NULL,
    PRIMARY KEY (classno, patid),
    constraint fk_dis_addr FOREIGN KEY(classno) REFERENCES addr(classno) on delete restrict on update CASCADE,
    constraint fk_dis_pat FOREIGN KEY(patid) REFERENCES pat(id) on delete restrict on update CASCADE
);--create classroom disinfection table 

create table adis(
    apano varchar(50) NOT NULL,
    patid BIGINT NOT NULL,
    isdis char(4) NOT NULL,
    PRIMARY KEY(apano,patid),
    constraint fk_adis_apa FOREIGN KEY(apano) REFERENCES apa(apano) on delete restrict on update CASCADE,
    constraint fk_adis_pat FOREIGN KEY(patid) REFERENCES pat(id) on delete restrict on update CASCADE
);--create apartment disinfection table


CREATE TABLE isino (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idepnam VARCHAR(50),
    status CHAR(4),
    mark VARCHAR(10)
);--create isino table