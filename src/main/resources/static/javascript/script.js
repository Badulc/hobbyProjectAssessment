'use strict'

import * as DOM from './dom.js';

/* let addToList = str => {
    let child = document.createElement(`li`);
    child.innerHTML = str;
    DOM.textOutput.appendChild(child);
} */


// POST function
const post = () => {
    axios.post('http://localhost:8080/createSnkr/', {   
                              name : DOM.nameInput.value,
                              serialNo : DOM.serialNoInput.value, 
                              size : DOM.sizeInput.value,
                              condition : DOM.conditionInput.value,
                              colour1 : DOM.colour1Input.value,
                              colour2 : DOM.colour2Input.value,
                              material : DOM.materialInput.value})
      .then((response) => {
        console.log(response);
        //get();
      }).catch((err) => {
        console.log(err);
      });
  }

  //update function
const updateId = () => {
  let id = DOM.updateId.value
  axios.put(`/replaceSnkr/`+id, {

    name : DOM.updateName.value,
    serialNo : DOM.updateSerialNo.value, 
    size : DOM.updateSize.value,
    condition : DOM.updateCondition.value,
    colour1 : DOM.updateColour1.value,
    colour2 : DOM.updateColour2.value,
    material : DOM.updateMaterial.value
      
  }) 
  .then((response) => {
    console.log(response);
    //get();
  }).catch((err) => {
    console.log(err);
  });
}

//delete function
const deleteId = () => {
  let id = DOM.deleteId.value
  axios.delete(`/removeSnkr/`+id)
  
  .then((response) => {
    console.log(response);
    get();
  }).catch((err) => {
    console.log(err);
  });

}



// GET all function
const get = () => {
  DOM.listOutput.innerHTML = ``;

  axios.get(`/getAllSnkr`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem(response.data);
      } else {
        for (let item of response.data) {
          writeItem(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}

// list item function
const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item._id;
  child.innerHTML = `${JSON.stringify(item)}`;
  DOM.listOutput.appendChild(child);
}


DOM.createButton.onclick = () => post();
DOM.updateButton.onclick = () => updateId();
DOM.deleteButton.onclick = () => deleteId();


DOM.viewAllButton.onclick = () => get();