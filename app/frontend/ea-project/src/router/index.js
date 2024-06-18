import {createWebHistory, createRouter } from "vue-router";

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("@/views/Home.vue"),
    meta: { requiresAuth: true },
  },
  {
    path: "/administration",
    name: "administration",
    component: () => import("@/views/Administration.vue"),
    meta: { requiresAuth: true },
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/views/Login.vue"),
  },
  {
    path: "/register",
    name: "register",
    component: () => import("@/views/Register.vue"),
  },
  {
    path: '/competition-detail/:id',
    name:'competition-detail',
    component: () => import('@/views/CompetitionDetail.vue'),
    props: true,
  },
  {
    path: "/competitions",
    name: "view-competitions",
    component: () => import("@/views/ViewCompetitions.vue"),
  },
  {
    path: '/race/:raceId',
    name: 'RaceDetails',
    component: () => import("@/views/RaceDetails.vue"),
    props: true
  },
  {
    path: "/trials",
    name: "view-trials",
    component: () => import("@/views/ViewTrials.vue"),
  },
  {
    path: "/create-competition",
    name: "create-competition",
    component: () => import("@/views/CreateCompetition.vue"),
  },
  {
    path: "/create-trial",
    name: "create-trial",
    component: () => import("@/views/CreateTrial.vue"),
  },
  {
    path: "/edit-competition/:id",
    name: "edit-competitions",
    component: () => import("@/views/EditCompetitions.vue"),
  },
  {
    path: "/edit-trial",
    name: "edit-trials",
    component: () => import("@/views/EditTrials.vue"),
  },
  {
    path: "/insert-results",
    name: "InsertResults",
    component: () => import("@/views/InsertResults.vue"),
  },
  {
    path: '/recover-password',
    name: 'RecoverPassword',
    component: () => import('@/views/RecoverPassword.vue'),
  },
  {
    path: '/teams',
    name: 'view-teams',
    component: () => import('@/views/ViewTeams.vue'),
  },
  {
    path: "/view-results",
    name: "view-results",
    component: () => import("@/views/ViewResults.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// Navigation guard to check for authentication
router.beforeEach((to, from, next) => {
  // Check if the route requires authentication
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    // Check if token exists in localStorage
    const token = localStorage.getItem("jwt-token");
    if (!token) {
      // Token does not exist, redirect to login page
      next("/login");
    } else {
      // Token exists, continue to the requested route
      next();
    }
  } else {
    // If the route doesn't require authentication, continue normally
    next();
  }
});

export default router;
