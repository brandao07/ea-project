module.exports = {
    root: true,
    env: {
      node: true,
    },
    extends: ["plugin:vue/essential", "eslint:recommended"],
    parserOptions: {
      parser: "babel-eslint",
      requireConfigFile: false
    },
    rules: {
      "no-console": process.env.NODE_ENV === "production" ? "warn" : "off",
      'vue/multi-word-component-names': 'off',
    },
  };
  