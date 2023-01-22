
const app = Vue.
createApp({
  data() {
    return {
      comunications: [],
      newTitle: "",
      newContent: "",
    };
  },
  created() {
    this.getData();
    this.getComunication();
  },
  methods: {
    getData() {
      axios.get("/api/clients/current").then((response) => {
        this.admin = response.data
      });
    },
    getComunication() {
      axios.get("/api/comunications").then((response) => {
        this.comunications = response.data;
      });
    },
    createComunication() {
      axios.post('/api/comunication/admin',`title=${this.newTitle}&content=${this.newContent}`)
          .then( () => Swal.fire(
            'Create Comunication',
            'Are you sure to Create Comunication?',
            'question'
          ))
        .then(() => window.location.href = '/admin/manager.html')
        .catch(error => {
          Swal.fire({
              icon: 'error',
              title: 'Oops... ',
              text: error.response.data,
              confirmButtonColor: "#028484",
            })
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
  },
}).mount("#app");
