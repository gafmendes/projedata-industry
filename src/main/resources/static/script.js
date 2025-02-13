function listEmployees() {
    fetch('/employees')
        .then(response => response.json())
        .then(data => {
            let tabela = document.getElementById("tabela-funcionarios");
            tabela.innerHTML = "";
            data.forEach(employee => {
                let row = `<tr>
                    <td>${employee.name}</td>
                    <td>${new Date(employee.birthday).toLocaleDateString()}</td>
                    <td>${employee.salary.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'})}</td>
                    <td>${employee.function}</td>
                </tr>`;
                tabela.innerHTML += row;
            });
        })
        .catch(error => console.error('Erro:', error));
}

function raiseSalary() {
    fetch('/employees/raise-salary', { method: 'PUT' })
        .then(() => listEmployees())
        .catch(error => console.error('Erro:', error));
}

function removeEmployee(name) {
    fetch(`/employees/remove/${name}`, { method: 'DELETE' })
        .then(() => listEmployees())
        .catch(error => console.error('Erro:', error));
}

function calculateTotalSalaries() {
    fetch('/employees/total-salaries')
        .then(response => response.json())
        .then(data => document.getElementById("resultado").innerText = `Total Salários: R$ ${data.toLocaleString('pt-BR', {minimumFractionDigits: 2})}`)
        .catch(error => console.error('Erro:', error));
}

function listBirthdays() {
    fetch('/employees/birthdays')
        .then(response => response.json())
        .then(data => {
            let names = data.map(e => e.name).join(', ');
            document.getElementById("resultado").innerText = `Aniversariantes (Out/Dez): ${names}`;
        })
        .catch(error => console.error('Erro:', error));
}
