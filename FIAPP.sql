drop table JAVA_DESPESA;
drop table JAVA_CATEGORIA;

create table JAVA_CATEGORIA(
    ID_CATEGORIA number,
    CATEGORIA varchar2(50),
    primary key (ID_CATEGORIA)
);

select * from java_categoria;

insert into JAVA_CATEGORIA values (1, 'transporte');
insert into JAVA_CATEGORIA values (2, 'moradia');

delete from JAVA_CATEGORIA where id_categoria=1;

commit;