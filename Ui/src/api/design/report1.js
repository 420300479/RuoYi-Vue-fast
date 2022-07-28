// label
[{label: 'Username'}]

// field
[
    {label: 'Username', field: row.username},
    {label: 'First Name', field: row.user.first_name},
]
   
// representedAs
  [
    {
      label: 'Address', representedAs: function (row) {
        return row.address + ', ' + row.city + ', ' + row.state;
      }
    }
  ]

  // component
  Vue.component('edit-button', {
    template: `
              < button class= "btn btn-xs btn-primary" @click="goToUpdatePage" > Edit</button >
              `,
    props: [row],
    methods: {
      goToUpdatePage: function(){
        window.location = '/contact/' + this.row.id + '/update';
      }
    }
  });
  
  //...
  
  {
    label: '',
    component: 'edit-button',
    representedAs: function(row){
      // This is only required if you want to enable
      // sorting and filtering on this column
      return row.id;
    }
  }
      
  // head components
  Vue.component('select-all', {
    template: `
              <input type="checkbox" @click="$emit('select-all')">
              `
  });
  
  //...
  
  {
    label: '',
    componentHeader: 'select-all'
  }
 
  //align
  
  [{label: 'Username', align: 'center'}]

    //sortable
  [{label: 'ID', sortable: false}]

    //filterable
  [{label: 'ID', filterable: false}]


// data as an array
  [
    {
      id: 1,
      first_name: 'John',
      last_name: 'Doe',
      birthdate: '1980-01-24'
    }
  ]
   // data as a function
            
  function(){
    return [
      {
        id: 1,
        first_name: 'John',
        last_name: 'Doe',
        birthdate: '1980-01-24'
      }
    ]
  }