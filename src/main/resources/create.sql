
CREATE TABLE IF NOT EXISTS people (
    id SERIAL PRIMARY KEY,
    dtype VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    salary DECIMAL(10,2),
    function VARCHAR(50)
);

INSERT INTO people (dtype, name, birthday, salary, function) VALUES
('Employee', 'Maria', '2000-10-18', 2009.44, 'Operador'),
('Employee', 'João', '1990-05-12', 2284.38, 'Operador'),
('Employee', 'Caio', '1961-05-02', 9836.14, 'Coordenador'),
('Employee', 'Miguel', '1988-10-14', 19119.88, 'Diretor'),
('Employee', 'Alice', '1995-01-05', 2234.68, 'Recepcionista'),
('Employee', 'Heitor', '1999-11-19', 1582.72, 'Operador'),
('Employee', 'Arthur', '1993-03-31', 4071.84, 'Contador'),
('Employee', 'Laura', '1994-07-08', 3017.45, 'Gerente'),
('Employee', 'Heloísa', '2003-05-24', 1606.85, 'Eletricista'),
('Employee', 'Helena', '1996-09-02', 2799.93, 'Gerente');