<template>
    <div id="administration">
        <NavigationBar />
        <div class="grid text-center">
            <div class="row">
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                        <span>Alterar Roles</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'cog']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'home']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'cog']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'home']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'cog']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'home']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'cog']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
                <div class="col">
                    <a class="btn btn-custom">
                        <font-awesome-icon :icon="['fas', 'home']" class="icon" />
                        <span>Button</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import NavigationBar from '@/components/NavigationBar.vue';

export default {
    name: 'administration',
    data() {
        return {
        }
    },
    components: {
        NavigationBar
    }
}

</script>

<style scoped>
.grid {
    padding-top: 20px;
    width: auto;
    justify-content: space-evenly;
    align-items: center;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: center;
}

.btn-custom {
    background-color: #fff;
    width: 125px;
    height: 125px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    border-radius: 0px;
    padding: 15px;
}

.btn-custom:hover {
    border-color: #ccc;
}

.icon {
    margin: 15px 0px;
    font-size: 24px;
}
</style>