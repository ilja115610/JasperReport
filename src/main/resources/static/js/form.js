const submitButton = document.querySelector('#submit');

submitButton.addEventListener('click',submit);

const form = document.querySelector('#form');
let fileName = '';

function submit(el){
    const data = Object.fromEntries(new FormData(form).entries());
    el.preventDefault();
    fetch('http://localhost:8080/form/pdf', {
        body: JSON.stringify(data),
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    })
        .then(response => {
            if (response.status === 400) {
                throw response;
            }
            resetForm();
            response.headers.forEach((h) => {
                    if (h.includes('filename')) {
                        fileName = h.split('=')[1];
                    }
                }
            );
            return response.blob();
        })
        .then(response => {
            const blob = new Blob([response], {type: 'application/pdf'});
            const downloadUrl = URL.createObjectURL(blob);
            const a = document.createElement("a");
            a.href = downloadUrl;
            a.download = fileName;
            document.body.appendChild(a);
            a.click();
        })
        .catch(err=>{
           err.json().then(e=>{
               e.forEach(a=>{
                   document.querySelector('#'+a.field).classList.add('error');
               })
           })
        })

}

function resetForm () {
    Array.from(form.elements).forEach((input) => {
        if(input.classList.contains('error')){
            input.classList.remove('error')
        }
    });
}





