const { createApp } = Vue
const { loadModule } = window['vue3-sfc-loader'];
const { createVuetify } = Vuetify

const options = {
    moduleCache: {
        vue: Vue,
    },
    getFile(url) {
        return fetch(url).then((resp) =>
            resp.ok ? resp.text() : Promise.reject(resp)
        );
    },
    addStyle(styleStr) {
        const style = document.createElement('style');
        style.textContent = styleStr;
        const ref = document.head.getElementsByTagName('style')[0] || null;
        document.head.insertBefore(style, ref);
    },
    log(type, ...args) {
        console.log(type, ...args);
    },
};

const app = createApp({
    components: {
        VHome: Vue.defineAsyncComponent(() =>
            loadModule('components/Home.vue', options)
        ),
        VSampleDataTable: Vue.defineAsyncComponent(() =>
            loadModule('components/SampleDataTable.vue', options)
        )
    },
})
.use(createVuetify())
.mount('#app')