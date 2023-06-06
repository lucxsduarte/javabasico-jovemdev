--1
select * from cargo;

--2
select nome, qt_vereadores from cidade order by cidade.nome;

--3
select nome, qt_vereadores from cidade where cidade.qt_vereadores > 9;

--4
select count(*) from cidade where cidade.qt_vereadores > 9;

--5
select max(cidade.qt_vereadores) from cidade;

--6
select cidade.nome from cidade where qt_vereadores = (select max(cidade.qt_vereadores) from cidade);

--7
select candidato.nome, candidato.cargo from candidato where candidato.cargo = 1 order by nome;

--8
select candidato.nome, candidato.cargo from candidato where nome like '%MARIA%' and candidato.cargo = 2 order by nome;

--9 
select candidato.nome, candidato.cargo from candidato where nome like 'Y%' and candidato.cargo = 2 order by nome;

--10
select 
	cidade.nome, candidato.nome 
from 
	cidade 
inner join 
	candidato 
	on 
	candidato.cidade = cidade.id 
	and 
	candidato.cargo = 1 
order by 
cidade.nome, candidato.nome;


--11
select 
	cidade.nome, candidato.nome
from 
	cidade
inner join 
	candidato
	on
	candidato.cidade = cidade.id
	and
	candidato.cargo = 1	
where 
	cidade.nome = 'TUBARÃO'	
order by 
	candidato.nome;	
	
--12
select 
	candidato.nome, cidade.nome
from 
	cidade 
inner join 
	candidato 
	on 
	candidato.cidade = cidade.id 
	and 
	candidato.cargo = 1 
where 
	qt_eleitores = (select max(qt_eleitores) from cidade);

--13
select 
	count(*) 
from 
	candidato 
inner join 
	cidade 
	on 
	cidade.id = candidato.cidade 
	and 
	cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador';

--14
select cidade.nome, count(cand.*)
from cidade 
inner join candidato cand on cand.cidade = cidade.id
inner join cargo on cargo.id = cand.cargo and cargo.nome = 'Vereador'
group by cidade.nome
order by cidade.nome;

--15
select 
	cargo.nome, vi.brancos, vi.nulos 
from 
	voto_invalido vi
inner join 
	cidade 
	on 
	vi.cidade = cidade.id 
	and 
	cidade.nome = 'TUBARÃO' 
inner join cargo on cargo.id = vi.cargo


--16
select 
	sum(brancos + nulos) 
from 
	voto_invalido 
inner join 
	cidade 
	on 
	cidade.id = voto_invalido.cidade 
	and 
	cidade.nome = 'TUBARÃO' 
inner join cargo on cargo.id = voto_invalido.cargo and cargo.nome = 'Prefeito';
--4.797


--17
select candidato.nome, voto.voto, cidade.nome from candidato 
inner join voto on voto.candidato = candidato.id
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by voto.voto desc;
--52.045

--18
select candidato.nome, voto.voto, cidade.nome from candidato 
inner join voto on voto.candidato = candidato.id
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
order by voto.voto DESC; 

--19
select max(voto.voto), cidade.nome from candidato
inner join voto on voto.candidato = candidato.id 
inner join cidade on candidato.cidade = cidade.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

--20
select partido.sigla, sum(voto.voto) as votos from candidato
inner join partido on partido.id = candidato.partido 
inner join voto on voto.candidato = candidato.id
inner join cidade on candidato.cidade = cidade.id and cidade.nome = 'TUBARÃO'
group by partido.sigla
order by votos desc;

--21
select candidato.cargo, sum(voto.voto) + sum(brancos + nulos) from voto
inner join candidato on candidato.id = voto.candidato 
inner join voto_invalido on voto_invalido.cidade = candidato.cidade
inner join cidade on candidato.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by candidato.cargo;


--22
select count(candidato.partido) from candidato
inner join partido on candidato.partido = partido.id and partido.id = 1;

select sum(voto.voto) from candidato
inner join partido on candidato.partido = partido.id 























