const { createApp } = Vue

createApp({
    data() {
    return {
        clients: "",
        comunications: ""
    }
    },
    created (){
        this.getData();
        this.getComunication();
    },
    methods:{
    getData(){        
        axios
        .get('/api/clients/current')
        .then(response => {
            this.clients = response.data
        }) 
    },
    getComunication() {
        axios.get("/api/comunications").then((response) => {
          this.comunications = response.data;
        });
      },
    logout() {
        axios.post('/api/logout')
        .then( () => Swal.fire(
          'Logout?',
          'Are you sure to leave?',
          'question'
        ))
        .then(() => window.location.href = '/web/index.html')

    },
    }

}).mount('#app')