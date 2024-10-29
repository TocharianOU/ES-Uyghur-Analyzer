# Elasticsearch Uyghur Analyzer Plugin

## Project Introduction
This plugin provides support for Uyghur text analysis in Elasticsearch, featuring two analyzers and corresponding token filters specifically designed for processing Uyghur text. It is ideal for users who need advanced linguistic processing for Uyghur, with options for morphology restoration and direct segmentation.

## Features
- **Two Tokenization Methods**: The plugin includes two specialized tokenizers for Uyghur text processing:
  1. **uyghur_original_tokenizer**: This tokenizer performs morphological restoration by reversing vowel weakening, bringing semantic units back to their original forms.
  2. **uyghur_split_tokenizer**: This tokenizer performs direct segmentation, preserving vowel-weakened forms in the tokenized text.

- **Stemming and Linguistic Analysis**: Supports stemming and other linguistic feature analyses optimized for Uyghur, enhancing text processing accuracy.

- **Flexible Configuration**: Both tokenizers can be configured based on specific use cases, allowing for customizable Uyghur text processing in Elasticsearch.

## Quick Start
To quickly get started with the plugin, follow these steps:

1. **Install the Plugin**: Follow the installation instructions in the [Getting Started Guide](docs/getting_started.md).
2. **Configure the Tokenizers**:
   - Add `uyghur_original_tokenizer` for morphology-restoring tokenization.
   - Add `uyghur_split_tokenizer` for direct segmentation with vowel weakening preserved.
3. **Run Sample Queries**: Use sample queries to validate tokenization and filtering based on your requirements.

For detailed setup and example configurations, please see the [Getting Started Guide](docs/getting_started.md).

## Installation
Supported Elasticsearch Version: **[Specify Supported Versions]**.

1. Ensure your Elasticsearch version is compatible with this plugin.
2. Follow the step-by-step installation instructions provided in the [Getting Started Guide](docs/getting_started.md).

## Dictionary Configuration
The plugin includes dictionaries for morphological analysis, which you can customize according to your needs. For detailed dictionary configuration instructions, please refer to the [Dictionary Explanation](docs/dictionary_explanation.md).

## Contribution Guide
We welcome contributions from the community to improve and expand this plugin! Please see the [Contribution Guide](docs/contribution_guide.md) for information on setting up a development environment, making contributions, and our coding standards.

## Frequently Asked Questions
Encountering issues or need additional guidance? Check out our [FAQ](docs/faq.md) for solutions to common problems and troubleshooting steps.

## License
This project is licensed under the Apache License 2.0. For more information, please see the [LICENSE](LICENSE) file.

## External Resources
This project utilizes the THUUyMorph dataset, a morphology-based Uyghur language segmentation corpus developed by the Tsinghua University Natural Language Processing and Computational Social Science Lab.

For more information and to access the dataset, see: [THUUyMorph](http://thuuymorph.thunlp.org/).

If you use this dataset in your work, please cite the following paper:
- THUUyMorph - A Uyghur Morphological Analysis Corpus. Presented at the CCL/NLP-NABD 2017 Conference.

The dictionaries `ug_mor_original.txt` and `ug_mor_split.txt` used in this project are based on resources provided by Tsinghua University and the mentioned paper. We extend our thanks to Tsinghua University for making this valuable resource available.

## Support and Help
If you encounter any problems while using this plugin, you can seek help through the following channels:

1. **GitHub Issues**: For technical issues or feature requests, submit an issue directly on the [GitHub Issues page](https://github.com/your-repo/issues).
2. **Community Forums and Groups**: Join relevant technical forums or communities to connect with other users and developers of this plugin, where you can find helpful insights and solutions.
3. **Direct Contact**: For more direct support, consider reaching out to the main developers or maintainers of the plugin.

---

Thank you for using the **Elasticsearch Uyghur Analyzer Plugin**! We hope it enhances your text processing capabilities for Uyghur language content.
