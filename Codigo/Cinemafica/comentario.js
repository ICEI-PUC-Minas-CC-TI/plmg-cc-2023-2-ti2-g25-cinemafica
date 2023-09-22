//do comentar 
let input = document.querySelector('.entered-list');
let addBnt = document.querySelector('.add-list');
let tasks = document.querySelector('.tasks');

input.addEventListener('keyup', () => {
    if(input.value.trim() != 0){
        addBnt.classList.add('active');
    }else{
        addBnt.classList.remove('active');
    }
})

addBnt.addEventListener('click', () =>{
    if(input.value.trim() != 0){
        let newItem = document.createElement('div');
        newItem.classList.add('item');
        newItem.innerHTML = ` <p> ${'@cinemafica: ' + input.value}</p>
        <div class="item-bnt">
            <i class="fa-solid fa-rectangle-xmark"></i>
        </div>`

        tasks.appendChild(newItem);
        input.value = '';
    }else{
        alert('Campo vazio! Escreva algo');
    }
})

tasks.addEventListener('click', (e)=>{
    if (e.target.classList.contains('fa-rectangle-xmark')){
        e.target.parentElement.parentElement.remove();
    }
})

tasks.addEventListener('click', (e)=>{
    if (e.target.classList.contains('fa-pen-to-square')){
        e.target.parentElement.parentElement.classList.toggle('completed');
    }
})