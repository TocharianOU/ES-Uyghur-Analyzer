# Getting Started with the Uyghur Text Analysis Plugin for Elasticsearch

Welcome to the Uyghur Text Analysis Plugin! This guide will provide step-by-step instructions for installing, configuring, and testing the plugin in your Elasticsearch environment.

## Prerequisites

Ensure the following before starting:
- Elasticsearch 8.7.0 or higher is installed.
- Access to the server command line where Elasticsearch is installed.
- Administrative rights to manage Elasticsearch plugins.

## Installation

Follow these steps to install the Uyghur Text Analysis Plugin:

1. **Download the Plugin**
   - Download the `.zip` file from the GitHub releases page.

2. **Install the Plugin**
   - Open your Elasticsearch directory on the command line and run:
     ```bash
     bin/elasticsearch-plugin install file:///path/to/plugin/uyghur-analysis-plugin.zip
     ```
   - Replace `/path/to/plugin/` with the path where the downloaded `.zip` file is located.

3. **Verify Installation**
   - Restart Elasticsearch and ensure the plugin is loaded by running:
     ```bash
     curl -X GET "localhost:9200/_cat/plugins?v=true"
     ```
   - Confirm that `uyghur_analysis_plugin` is listed among the installed plugins.

## Configuration

The `uyghur_original_analyzer` and `uyghur_split_analyzer` are  available out of the box and can be used immediately to analyze text:


```json
PUT /my_index
{
  "mappings": {
    "properties": {
      "content": {
        "type": "text",
        "analyzer": "uyghur_original_analyzer"
      },
      "content_split": {
        "type": "text",
        "analyzer": "uyghur_split_analyzer"
      }
    }
  }
}
```


```json
POST /my_index/_analyze
{
  "analyzer": "uyghur_original_analyzer",  //uyghur_split_analyzer
  "text": "يېزىلاردىكى ئېشىنچا ئەمگەكچىلەرنى"
}
```

This will return the text broken down into tokens based on Uyghur morphology.


### Configuring a Custom Analyzer

To set up a custom analyzer named `my_custom_analyzer`, use the following configuration for an index:

```json
PUT /costum_text
{
  "settings": {
    "analysis": {
      "analyzer": {
        "my_custom_analyzer": {
          "type": "custom",
          "tokenizer": "standard",
          "filter": ["uyghur_word_original"]
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "custom_content": {
        "type": "text",
        "analyzer": "my_custom_analyzer"
      }
    }
  }
}
```


## Next Steps

Explore the capabilities of both the pre-configured and custom analyzers. For any issues or further questions, refer to the [FAQ](faq.md) or open an issue on GitHub.

Thank you for using the Uyghur Text Analysis Plugin for Elasticsearch!


