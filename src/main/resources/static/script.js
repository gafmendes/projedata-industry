function listEmployees() {
    fetch(`/employees`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            updateTable(data);
        })
        .catch(error => console.error('Error:', error));
}

function raiseSalary() {
    fetch('/employees/raise-salary', { method: 'PUT' })
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            updateTable(data);
        })
        .catch(error => console.error('Erro:', error));
}

function removeEmployee(name) {
    fetch(`/employees/remove/${name}`, { method: 'DELETE' })
        .then(() => listEmployees())
        .catch(error => console.error('Erro:', error));
}

function calculateTotalSalaries() {
    fetch('/employees/total-salaries')
        .then(response => response.text())
        .then(data => {
            document.getElementById("resultado").innerText = `Total Salários: ${parseFloat(data).toLocaleString('pt-BR', {minimumFractionDigits: 2})}`;
        })
        .catch(error => console.error('Erro:', error));
}

function listBirthdays() {
    fetch('/employees/birthdays')
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "Outubro/Dezembro";
            updateTable(data);
        })
        .catch(error => console.error('Erro:', error));
}

function listSortedByName() {
    fetch('/employees/salary-name')
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            updateTable(data);
        })
        .catch(error => console.error('Erro:', error));
}

function oldestEmployee() {
    fetch('/employees/older')
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            updateTable([data]);
        })
        .catch(error => console.error('Erro:', error));
}

function groupByFunction() {
    fetch('/employees/group-by-function')
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            let formattedData = [];
            for (const [key, value] of Object.entries(data)) {
                formattedData = formattedData.concat(value);
            }
            updateTable(formattedData);
        })
        .catch(error => console.error('Erro:', error));
}

function calculateMinimumSalaries() {
    fetch('/employees/minimum-salaries')
        .then(response => response.json())
        .then(data => {
            document.getElementById("resultado").innerText = "";
            let formattedData = [];
            for (const [key, value] of Object.entries(data)) {
                formattedData.push({ name: key, salary: parseFloat(value).toFixed(2) });
            }
            updateTable(formattedData);
        })
        .catch(error => console.error('Erro:', error));
}

function updateTable(data) {
    const tabela = document.getElementById('tabela-funcionarios');
    tabela.innerHTML = '';
    data.forEach(employee => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${employee.name || '-'}</td>
            <td>${employee.birthday ? new Date(employee.birthday).toLocaleDateString() : '-'}</td>
            <td>${employee.salary ? parseFloat(employee.salary).toLocaleString('pt-BR', {minimumFractionDigits: 2}) : '-'}</td>
            <td>${employee.function || '-'}</td>
        `;
        tabela.appendChild(row);
    });
}