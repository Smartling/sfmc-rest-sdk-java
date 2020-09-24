package com.smartling.connector.exacttarget.sdk.data;

import lombok.Data;

import java.util.List;

@Data
public class PreviewMessage
{
    private PreviewLinks links;
    private List<PreviewView> views;
}
